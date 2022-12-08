package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.IngredientCommand;
import guru.springframework.sfgrecipeproject.domain.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientToIngredientCommandTest {
    private static final Long ID = 1L;
    private static final String NAME = "Salt for Test";
    IngredientToIngredientCommand ingredientToIngredientCommand;

    @BeforeEach
    void setUp() {
        ingredientToIngredientCommand = new IngredientToIngredientCommand();
    }

    @Test
    void convert() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setName(NAME);
        IngredientCommand ingredientCommand;

        //when
        ingredientCommand = ingredientToIngredientCommand.convert(ingredient);

        //then
        assertNotNull(ingredientCommand.getId());
        assertEquals(NAME, ingredientCommand.getName());
    }

    @Test
    void convertShouldReturnNull() {
        //given
        IngredientCommand ingredientCommand;

        //when
        ingredientCommand = ingredientToIngredientCommand.convert(null);

        //then
        assertNull(ingredientCommand);
    }
}