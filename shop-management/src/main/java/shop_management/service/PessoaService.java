package shop_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop_management.entity.Pessoa;
import shop_management.entity.PessoaDTO;
import shop_management.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public List<Pessoa> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public List<Pessoa> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<Pessoa> findByRaca(String raca) {
        return repository.findByRaca(raca);
    }

    public List<Pessoa> findByIdade(int idade) {
        return repository.findByIdade(idade);
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public List<Pessoa> savePessoas(List<Pessoa> pessoas) {
        List<Pessoa> peopleToSave = pessoas.stream()
                .filter(pessoa -> repository.findByEmail(pessoa.getEmail()).isEmpty())
                .collect(Collectors.toList());

        if (peopleToSave.isEmpty()) {
            throw new RuntimeException("Nenhuma pessoa nova para salvar, todos os emails já existem! Caso tenha outro email coloque-o");
        }

        return repository.saveAll(peopleToSave);
    }

    public Pessoa updatePessoa(Long id, PessoaDTO pessoa) {
        Pessoa existsperson = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));
        existsperson.setEmail(pessoa.getEmail());
        return repository.save(existsperson);
    }
}
