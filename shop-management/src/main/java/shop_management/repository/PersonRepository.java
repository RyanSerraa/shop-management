package shop_management.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop_management.entity.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
     public List<Person> findByName(String nome);
     public List<Person> findByEmail(String email);
     public List<Person> findByRace(String raca);
     public List<Person> findByAge(int idade);
}
