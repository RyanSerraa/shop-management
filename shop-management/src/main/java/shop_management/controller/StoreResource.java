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
import shop_management.entity.Store;
import shop_management.entity.StoreDTO;
import shop_management.service.StoreService;


@RestController
@RequestMapping(value= "/store", produces= "application/json")
@Tag(name ="Store")

public class StoreResource {
    private final StoreService service;

    public StoreResource(StoreService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<Store>> findAll(){
        return ResponseEntity.ok(service.findByAll());
    }

    @PostMapping
    public ResponseEntity<List<Store>> savePeople(@RequestBody List<Store> stores) {
        return ResponseEntity.ok(service.saveStores(stores));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> putMethodName(@PathVariable Long id, @RequestBody StoreDTO store) {
        return ResponseEntity.ok(service.updateStore(id, store));
    }
    
}
