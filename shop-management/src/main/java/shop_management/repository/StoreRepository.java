package shop_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop_management.entity.Store;

@Repository
public interface  StoreRepository extends JpaRepository<Store, Long> {
    public List<Store> findByName(String name);
}
