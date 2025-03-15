package shop_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop_management.entity.Product;
import shop_management.entity.PruductDTO;
import shop_management.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> findByAll() {
        return repository.findAll();
    }

    public List<Product> findByName(String nome) {
        return repository.findByName(nome);
    }

    public Product findById(Long id) {
        return repository.getReferenceById(id);
    }

     public List<Product> saveProduct(List<Product> produtos) {
        List<Product> productToSave = produtos.stream()
                .filter(produto -> repository.findByName(produto.getName()).isEmpty())
                .collect(Collectors.toList());
        return repository.saveAll(productToSave);
    }

    public Product updateProduct(Long id, PruductDTO produto) {
        Product existsProduto = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrada"));
        existsProduto.setPrice(produto.getPrice());
        return repository.save(existsProduto);
    }
}
