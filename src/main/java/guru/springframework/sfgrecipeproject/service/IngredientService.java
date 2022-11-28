package guru.springframework.sfgrecipeproject.service;

import guru.springframework.sfgrecipeproject.domain.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getIngredients();

    Ingredient save(Ingredient ingredient);

    void deleteById(Long id);
}
