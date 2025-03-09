package shop_management.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop_management.entity.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    public List<Produto> findByNome(String nome);
    
}