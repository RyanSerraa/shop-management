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
import shop_management.entity.Product;
import shop_management.entity.PruductDTO;
import shop_management.service.ProductService;





@RestController
@RequestMapping(value = "/product", produces = "application/json")
@Tag(name ="Product")

public class ProductResource {
    private final ProductService service;

    public ProductResource(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(service.findByAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<Product>> findByNome(String nome) {
        return ResponseEntity.ok(service.findByName(nome));
    }
    
    @PostMapping
    public ResponseEntity<List<Product>> saveProduct(@RequestBody List<Product> produtos) {
        return ResponseEntity.ok(service.saveProduct(produtos));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody PruductDTO price) {
        return ResponseEntity.ok(service.updateProduct(id, price));
    }
}
