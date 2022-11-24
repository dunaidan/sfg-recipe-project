package guru.springframework.sfgrecipeproject.repository;

import guru.springframework.sfgrecipeproject.domain.IngredientQuantity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientQuantityRepository extends CrudRepository<IngredientQuantity, Long> {
}
