/*package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Chef;

import java.util.List;
import java.util.Optional;

public interface ChefRepository {
    List<Chef> findAll();

    Optional<Chef> findById(Long id);

    Chef save(Chef chef);
}
*/
package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {
}