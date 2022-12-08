package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.CategoryCommand;
import guru.springframework.sfgrecipeproject.domain.Category;
import guru.springframework.sfgrecipeproject.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryToCategoryCommandTest {
    private static final Long ID = 1l;
    public static final String MOLDOVAN_FOOD = "Moldovan Food";
    CategoryToCategoryCommand categoryToCategoryCommand;
    Category category;

    @BeforeEach
    void setUp() {

        categoryToCategoryCommand = new CategoryToCategoryCommand();

        category = new Category();
        category.setId(ID);
        category.setDescription(MOLDOVAN_FOOD);
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe());
        category.setRecipes(recipes);
    }

    @Test
    void convert() {
        //given
        CategoryCommand categoryCommand;

        //when
        categoryCommand = categoryToCategoryCommand.convert(category);

        //then
        assertNotNull(categoryCommand);
        assertNotNull(categoryCommand.getId());
        assertEquals(MOLDOVAN_FOOD, categoryCommand.getDescription());
    }

    @Test
    void convertShouldReturnNull() {
        //given
        CategoryCommand categoryCommand;

        //when
        categoryCommand = categoryToCategoryCommand.convert(null);

        //then
        assertNull(categoryCommand);
    }
}