package shop_management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import shop_management.entity.Person;
import shop_management.entity.PersonDTO;
import shop_management.service.PersonService;


@RestController
@RequestMapping(value = "/person", produces = "application/json")
@Tag(name ="Person")
public class PersonResource {
    private final PersonService service;

    public PersonResource(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAllPessoas() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<List<Person>> savePeople(@RequestBody List<Person> pessoas) {
        return ResponseEntity.ok(service.savePersons(pessoas));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> putMethodName(@PathVariable Long id, @RequestBody PersonDTO pessoa) {
        return ResponseEntity.ok(service.updatePersons(id, pessoa));
    }
    
}

