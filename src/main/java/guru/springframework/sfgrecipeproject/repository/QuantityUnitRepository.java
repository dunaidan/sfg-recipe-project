package guru.springframework.sfgrecipeproject.repository;

import guru.springframework.sfgrecipeproject.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityUnitRepository extends CrudRepository<UnitOfMeasure, Long> {
}
