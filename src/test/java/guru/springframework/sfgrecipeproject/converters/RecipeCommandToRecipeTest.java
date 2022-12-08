package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.*;
import guru.springframework.sfgrecipeproject.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCommandToRecipeTest {
    public static final long ID = 1L;
    public static final String TITLE = "Recipe Title";
    public static final int PREP_TIME = 10;
    public static final int COOK_TIME = 20;
    public static final int SERVINGS = 4;
    public static final String SOURCE = "Recipe Source";
    public static final String URL = "https://recipes.com";
    public static final String NOTES = "Recipe Notes";
    public static final String DIRECTIONS = "Recipe Directions";
    public static final LocalDateTime TIMESTAMP = LocalDateTime.of(2022, 12, 8, 15, 9);
    public static final String INGREDIENT_NAME = "Salt for Test";
    public static final String CATEGORY_DESCRIPTION = "Recipe Category";
    public static final Difficulty DIFFICULTY = Difficulty.EASY;

    RecipeCommandToRecipe recipeConverter;
    RecipeCommand recipeCommand;

    @BeforeEach
    void setUp() {
        NotesCommandToNotes notesConverter = new NotesCommandToNotes();
        IngredientQuantityCommandToIngredientQuantity ingredientConverter =
                new IngredientQuantityCommandToIngredientQuantity(new IngredientCommandToIngredient(), new UnitOfMeasureCommandToUnitOfMeasure());
        CategoryCommandToCategory categoryConverter = new CategoryCommandToCategory();

        recipeConverter = new RecipeCommandToRecipe(notesConverter, ingredientConverter, categoryConverter);

        recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID);
        recipeCommand.setTitle(TITLE);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);
        NotesCommand notes = new NotesCommand();
        notes.setRecipeNotes(NOTES);
        recipeCommand.setNotes(notes);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setTimestamp(TIMESTAMP);
        List<IngredientQuantityCommand> ingredients = new ArrayList<>();
        IngredientQuantityCommand ingredientQuantity = new IngredientQuantityCommand();
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setName(INGREDIENT_NAME);
        ingredientQuantity.setIngredientCommand(ingredientCommand);
        ingredients.add(ingredientQuantity);
        recipeCommand.setIngredientsCommand(ingredients);
        CategoryCommand category = new CategoryCommand();
        category.setDescription(CATEGORY_DESCRIPTION);
        List<CategoryCommand> categories = new ArrayList<>();
        categories.add(category);
        recipeCommand.setCategoriesCommand(categories);
        recipeCommand.setDifficulty(DIFFICULTY);
    }

    @Test
    void convert() {
        //given
        Recipe recipe;

        //when
        recipe = recipeConverter.convert(recipeCommand);

        //then
        assertNotNull(recipe);
        assertEquals(ID, recipe.getId());
        assertEquals(TITLE, recipe.getTitle());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(NOTES, recipe.getNotes().getRecipeNotes());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(TIMESTAMP, recipe.getTimestamp());
        assertEquals(1, recipe.getIngredients().size());
        assertEquals(INGREDIENT_NAME, recipe.getIngredients().get(0).getIngredient().getName());
        assertEquals(1, recipe.getCategories().size());
        assertEquals(CATEGORY_DESCRIPTION, recipe.getCategories().get(0).getDescription());
    }
}