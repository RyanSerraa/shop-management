package shop_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop_management.entity.Produto;
import shop_management.entity.ProdutoDTO;
import shop_management.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public List<Produto> findByAll() {
        return repository.findAll();
    }

    public List<Produto> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public Produto findById(Long id) {
        return repository.getReferenceById(id);
    }

     public List<Produto> saveProduto(List<Produto> produtos) {
        List<Produto> peopleToSave = produtos.stream()
                .filter(produto -> repository.findByNome(produto.getNome()).isEmpty())
                .collect(Collectors.toList());

        if (peopleToSave.isEmpty()) {
            throw new RuntimeException("Nenhuma pessoa nova para salvar, todos os emails já existem! Caso tenha outro email coloque-o");
        }

        return repository.saveAll(peopleToSave);
    }

    public Produto updateProduto(Long id, ProdutoDTO produto) {
        Produto existsProduto = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrada"));
        existsProduto.setPreco(produto.getPreco());
        return repository.save(existsProduto);
    }
}
