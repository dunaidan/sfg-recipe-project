package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.IngredientCommand;
import guru.springframework.sfgrecipeproject.domain.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {
    private static final Long ID = 1L;
    private static final String NAME = "Salt for Test";
    IngredientCommand ingredientCommand;
    IngredientCommandToIngredient ingredientCommandToIngredient;

    @BeforeEach
    void setUp() {
        ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ID);
        ingredientCommand.setName(NAME);

        ingredientCommandToIngredient = new IngredientCommandToIngredient();
    }

    @Test
    void convert() {
        //given
        Ingredient ingredient;

        //when
        ingredient = ingredientCommandToIngredient.convert(ingredientCommand);

        //then
        assertEquals(ID, ingredient.getId());
        assertEquals(NAME, ingredient.getName());
    }

    @Test
    void convertShouldReturnNull() {
        //given
        Ingredient ingredient;

        //when
        ingredient = ingredientCommandToIngredient.convert(null);

        //then
        assertNull(ingredient);
    }
}