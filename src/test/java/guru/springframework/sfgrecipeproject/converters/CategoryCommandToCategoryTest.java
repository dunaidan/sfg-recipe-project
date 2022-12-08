package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.CategoryCommand;
import guru.springframework.sfgrecipeproject.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {
    public static final long ID = 1L;
    public static final String MOLDOVAN_FOOD = "Moldovan Food";
    CategoryCommandToCategory categoryCommandToCategory;
    CategoryCommand categoryCommand;

    @BeforeEach
    void setUp() {
        categoryCommandToCategory = new CategoryCommandToCategory();
        categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID);
        categoryCommand.setDescription(MOLDOVAN_FOOD);
    }

    @Test
    void convert() {
        //given
        Category category;

        //when
        category = categoryCommandToCategory.convert(categoryCommand);

        //then
        assertNotNull(category);
        assertEquals(ID, category.getId());
        assertEquals(MOLDOVAN_FOOD, category.getDescription());
    }
}