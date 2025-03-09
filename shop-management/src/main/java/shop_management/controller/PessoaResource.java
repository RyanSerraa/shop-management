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

import shop_management.entity.Pessoa;
import shop_management.entity.PessoaDTO;
import shop_management.service.PessoaService;


@RestController
@RequestMapping(value = "/pessoa", produces = "application/json")
public class PessoaResource {
    private final PessoaService service;

    public PessoaResource(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAllPessoas() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<List<Pessoa>> savePeople(@RequestBody List<Pessoa> pessoas) {
        return ResponseEntity.ok(service.savePessoas(pessoas));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> putMethodName(@PathVariable Long id, @RequestBody PessoaDTO pessoa) {
        return ResponseEntity.ok(service.updatePessoa(id, pessoa));
    }
    
}

