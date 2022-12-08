package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.RecipeCommand;
import guru.springframework.sfgrecipeproject.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeToRecipeCommandTest {

    public static final long ID = 1L;
    public static final String TITLE = "Recipe Title";
    public static final int PREP_TIME = 10;
    public static final int COOK_TIME = 20;
    public static final int SERVINGS = 4;
    public static final String SOURCE = "Recipe Source";
    public static final String URL = "http://recipes.com";
    public static final String NOTES = "Recipe Notes";
    public static final String DIRECTIONS = "Recipe Directions";
    public static final LocalDateTime TIMESTAMP = LocalDateTime.of(2022, 12, 8, 15, 9);
    public static final String INGREDIENT_NAME = "Salt for Test";
    public static final String CATEGORY_DESCRIPTION = "Recipe Category";
    public static final Difficulty DIFFICULTY = Difficulty.EASY;
    RecipeToRecipeCommand recipeConverter;
    Recipe recipe;

    @BeforeEach
    void setUp() {
        NotesToNotesCommand notesConverter = new NotesToNotesCommand();
        IngredientQuantityToIngredientQuantityCommand ingredientConverter =
                new IngredientQuantityToIngredientQuantityCommand(new IngredientToIngredientCommand(), new UnitOfMeasureToUnitOfMeasureCommand());
        CategoryToCategoryCommand categoryConverter = new CategoryToCategoryCommand();

        recipeConverter = new RecipeToRecipeCommand(notesConverter, ingredientConverter, categoryConverter);

        recipe = new Recipe();
        recipe.setId(ID);
        recipe.setTitle(TITLE);
        recipe.setPrepTime(PREP_TIME);
        recipe.setCookTime(COOK_TIME);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setUrl(URL);
        Notes notes = new Notes();
        notes.setRecipeNotes(NOTES);
        recipe.setNotes(notes);
        recipe.setDirections(DIRECTIONS);
        recipe.setTimestamp(TIMESTAMP);
        List<IngredientQuantity> ingredients = new ArrayList<>();
        IngredientQuantity ingredientQuantity = new IngredientQuantity();
        ingredientQuantity.setIngredient(new Ingredient(INGREDIENT_NAME));
        ingredients.add(ingredientQuantity);
        recipe.setIngredients(ingredients);
        Category category = new Category();
        category.setDescription(CATEGORY_DESCRIPTION);
        List<Category> categories = new ArrayList<>();
        categories.add(category);
        recipe.setCategories(categories);
        recipe.setDifficulty(DIFFICULTY);


    }

    @Test
    void convert() {
        //given
        RecipeCommand recipeCommand;

        //when
        recipeCommand = recipeConverter.convert(recipe);

        //then
        assertNotNull(recipeCommand);
        assertEquals(ID, recipeCommand.getId());
        assertEquals(TITLE, recipeCommand.getTitle());
        assertEquals(PREP_TIME, recipeCommand.getPrepTime());
        assertEquals(COOK_TIME, recipeCommand.getCookTime());
        assertEquals(SERVINGS, recipeCommand.getServings());
        assertEquals(SOURCE, recipeCommand.getSource());
        assertEquals(NOTES, recipeCommand.getNotes().getRecipeNotes());
        assertEquals(DIRECTIONS, recipeCommand.getDirections());
        assertEquals(TIMESTAMP, recipeCommand.getTimestamp());
        assertEquals(1, recipeCommand.getIngredientsCommand().size());
        assertEquals(INGREDIENT_NAME, recipeCommand.getIngredientsCommand().get(0).getIngredientCommand().getName());
        assertEquals(1, recipeCommand.getCategoriesCommand().size());
        assertEquals(CATEGORY_DESCRIPTION, recipeCommand.getCategoriesCommand().get(0).getDescription());
    }
}