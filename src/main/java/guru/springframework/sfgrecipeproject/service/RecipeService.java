package guru.springframework.sfgrecipeproject.service;

import guru.springframework.sfgrecipeproject.domain.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    List<Recipe> getRecipes();

    Recipe findById(Long id);

    Recipe save(Recipe recipe);
}
