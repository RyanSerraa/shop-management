package shop_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop_management.entity.Person;
import shop_management.entity.PersonDTO;
import shop_management.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> findByName(String nome) {
        return repository.findByName(nome);
    }

    public List<Person> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<Person> findByRace(String raca) {
        return repository.findByRace(raca);
    }

    public List<Person> findByAge(int idade) {
        return repository.findByAge(idade);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public List<Person> savePersons(List<Person> pessoas) {
        List<Person> peopleToSave = pessoas.stream()
                .filter(pessoa -> repository.findByEmail(pessoa.getEmail()).isEmpty())
                .collect(Collectors.toList());

        if (peopleToSave.isEmpty()) {
            throw new RuntimeException("Nenhuma pessoa nova para salvar, todos os emails já existem! Caso tenha outro email coloque-o");
        }

        return repository.saveAll(peopleToSave);
    }

    public Person updatePersons(Long id, PersonDTO pessoa) {
        Person existsperson = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));
        existsperson.setEmail(pessoa.getEmail());
        return repository.save(existsperson);
    }
}
