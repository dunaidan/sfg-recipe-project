package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.IngredientQuantityCommand;
import guru.springframework.sfgrecipeproject.domain.Ingredient;
import guru.springframework.sfgrecipeproject.domain.IngredientQuantity;
import guru.springframework.sfgrecipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientQuantityToIngredientQuantityCommandTest {

    public static final long ID = 1L;
    public static final String INGREDIENT_NAME = "Salt for Test";
    public static final String UNIT_OF_MEASURE = "grams";
    IngredientQuantityToIngredientQuantityCommand ingredientQuantityToIngredientQuantityCommand;
    IngredientQuantity ingredientQuantity;

    @BeforeEach
    void setUp() {

        ingredientQuantityToIngredientQuantityCommand = new IngredientQuantityToIngredientQuantityCommand(
                new IngredientToIngredientCommand(),
                new UnitOfMeasureToUnitOfMeasureCommand());

        ingredientQuantity = new IngredientQuantity();
        ingredientQuantity.setId(ID);
        ingredientQuantity.setIngredient(new Ingredient(INGREDIENT_NAME));
        ingredientQuantity.setUnitOfMeasure(new UnitOfMeasure(UNIT_OF_MEASURE));
    }

    @Test
    void convert() {
        //given
        IngredientQuantityCommand ingredientQuantityCommand;

        //when
        ingredientQuantityCommand = ingredientQuantityToIngredientQuantityCommand.convert(ingredientQuantity);

        //then
        assertNotNull(ingredientQuantityCommand);
        assertEquals(ID, ingredientQuantityCommand.getId());
        assertEquals(INGREDIENT_NAME, ingredientQuantityCommand.getIngredientCommand().getName());
        assertEquals(UNIT_OF_MEASURE, ingredientQuantityCommand.getUnitOfMeasureCommand().getName());
    }
}