package guru.springframework.sfgrecipeproject.repository;

import guru.springframework.sfgrecipeproject.domain.QuantityUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityUnitRepository extends CrudRepository<QuantityUnit, Long> {
}
