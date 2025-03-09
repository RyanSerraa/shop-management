package shop_management.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop_management.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    public List<Product> findByName(String name);
    
}