package shop_management.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop_management.entity.Pessoa;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
     public List<Pessoa> findByNome(String nome);
     public List<Pessoa> findByEmail(String email);
     public List<Pessoa> findByRaca(String raca);
     public List<Pessoa> findByIdade(int idade);
}
