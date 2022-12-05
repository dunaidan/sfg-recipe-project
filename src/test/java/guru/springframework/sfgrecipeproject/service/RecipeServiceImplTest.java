package guru.springframework.sfgrecipeproject.service;

import guru.springframework.sfgrecipeproject.domain.Recipe;
import guru.springframework.sfgrecipeproject.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        //given
        Recipe recipe = new Recipe();
        List<Recipe> recipes = new ArrayList<>();
        when(recipeRepository.findAll()).thenReturn(recipes);

        //when
        List<Recipe> returnedList  = recipeService.getRecipes();

        //then
        assertEquals(recipes.size(), returnedList.size());
        verify(recipeRepository, times(1)).findAll();
    }
}