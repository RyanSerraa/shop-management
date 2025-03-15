package shop_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop_management.entity.Store;
import shop_management.entity.StoreDTO;
import shop_management.repository.StoreRepository;

@Service 
public class StoreService {
    
    @Autowired
    StoreRepository repository;

    public List<Store> findByAll() {
        return repository.findAll();
    }

    public List<Store> findByName(String name) {
        return repository.findByName(name);
    }

    public Store findById(Long id) {
        return repository.getReferenceById(id);
    }

     public List<Store> saveStores(List<Store> stores) {
        List<Store> storeToSave = stores.stream()
                .filter(store -> repository.findByName(store.getName()).isEmpty())
                .collect(Collectors.toList());

        if (storeToSave.isEmpty()) {
            throw new RuntimeException("Nenhuma Loja nova para salvar, todos o email cadastrado já existe! Caso tenha outro email coloque-o");
        }

        return repository.saveAll(storeToSave);
    }

    public Store updateStore(Long id, StoreDTO store) {
        Store existsStore = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Loja não encontrada"));
        existsStore.setEmail(store.getEmail());
        existsStore.setCountry(store.getCountry());
        existsStore.setCity(store.getCity());
        existsStore.setState(store.getState());
        existsStore.setStreet(store.getStreet());
        existsStore.setNumber(store.getNumber());
        existsStore.setZip_code(store.getZip_code());
        return repository.save(existsStore);
    }
}
