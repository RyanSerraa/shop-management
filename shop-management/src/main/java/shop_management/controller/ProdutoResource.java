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

import shop_management.entity.Produto;
import shop_management.entity.ProdutoDTO;
import shop_management.service.ProdutoService;





@RestController
@RequestMapping(value = "/produto", produces = "application/json")
public class ProdutoResource {
    private final ProdutoService service;

    public ProdutoResource(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(service.findByAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<Produto>> findByNome(String nome) {
        return ResponseEntity.ok(service.findByNome(nome));
    }
    
    @PostMapping
    public ResponseEntity<List<Produto>> saveProduct(@RequestBody List<Produto> produtos) {
        return ResponseEntity.ok(service.saveProduto(produtos));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduct(@PathVariable Long id,@RequestBody ProdutoDTO price) {
        return ResponseEntity.ok(service.updateProduto(id, price));
    }
}
