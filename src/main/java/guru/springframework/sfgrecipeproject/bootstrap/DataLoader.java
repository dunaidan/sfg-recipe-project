package guru.springframework.sfgrecipeproject.bootstrap;

import guru.springframework.sfgrecipeproject.domain.*;
import guru.springframework.sfgrecipeproject.repository.IngredientQuantityRepository;
import guru.springframework.sfgrecipeproject.repository.IngredientRepository;
import guru.springframework.sfgrecipeproject.repository.QuantityUnitRepository;
import guru.springframework.sfgrecipeproject.service.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final RecipeService recipeService;
    private final IngredientRepository ingredientRepository;
    private final IngredientQuantityRepository ingredientQuantityRepository;
    private final QuantityUnitRepository quantityUnitRepository;

    public DataLoader(RecipeService recipeService, IngredientRepository ingredientRepository, IngredientQuantityRepository ingredientQuantityRepository, QuantityUnitRepository quantityUnitRepository) {
        this.recipeService = recipeService;
        this.ingredientRepository = ingredientRepository;
        this.ingredientQuantityRepository = ingredientQuantityRepository;
        this.quantityUnitRepository = quantityUnitRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Ingredient tomato = new Ingredient();
        tomato.setName("Tomato");
        ingredientRepository.save(tomato);

        QuantityUnit grams = new QuantityUnit();
        grams.setName("grams");
        quantityUnitRepository.save(grams);

        IngredientQuantity ingredientQuantity = new IngredientQuantity();
        ingredientQuantity.setIngredient(tomato);
        ingredientQuantity.setQuantity(200.00);
        ingredientQuantity.setQuantityUnit(grams);
        ingredientQuantityRepository.save(ingredientQuantity);

        Recipe pasta = new Recipe();
        pasta.setTitle("Pasta with Ton");
        pasta.setRecipeText("Pasta with ton, tomatoes and cheese");
        pasta.setMealType(MealType.DINNER);
        pasta.getIngredients().add(ingredientQuantity);
        recipeService.save(pasta);

    }
}
