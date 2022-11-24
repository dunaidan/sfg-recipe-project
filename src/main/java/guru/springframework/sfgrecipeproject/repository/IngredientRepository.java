package guru.springframework.sfgrecipeproject.repository;

import guru.springframework.sfgrecipeproject.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
