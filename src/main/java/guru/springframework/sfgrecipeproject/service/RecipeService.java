package guru.springframework.sfgrecipeproject.service;

import guru.springframework.sfgrecipeproject.domain.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getRecipes();
}
