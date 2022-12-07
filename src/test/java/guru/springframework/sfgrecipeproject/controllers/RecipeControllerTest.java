package guru.springframework.sfgrecipeproject.controllers;

import guru.springframework.sfgrecipeproject.domain.Recipe;
import guru.springframework.sfgrecipeproject.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class RecipeControllerTest {
    RecipeController recipeController;

    @Mock
    RecipeService recipeService;

    @BeforeEach
    void setUp() {
        recipeController = new RecipeController(recipeService);
    }

    @Test
    void recipeList() throws Exception {
        //given
        Recipe recipe = new Recipe();
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipes);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        //when
        //then
        mockMvc.perform(get("/recipe/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/list"))
                .andExpect(model().attributeExists("recipes"));
    }
}
