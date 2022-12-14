package guru.springframework.sfgrecipeproject.domain;

import org.junit.Before;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @org.junit.Test
    public void getId() {
        Long idValue = 4l;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @org.junit.Test
    public void getDescription() {
    }

    @org.junit.Test
    public void getRecipes() {
    }
}