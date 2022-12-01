package guru.springframework.sfgrecipeproject.controllers;

import guru.springframework.sfgrecipeproject.domain.Recipe;
import guru.springframework.sfgrecipeproject.repository.CategoryRepository;
import guru.springframework.sfgrecipeproject.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
public class IndexController {
    private final RecipeService recipeService;
    private final CategoryRepository categoryRepository;

    public IndexController(RecipeService recipeService, CategoryRepository categoryRepository) {
        this.recipeService = recipeService;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping({"","/","index.html", "index"})
    public String getRecipes(Model model) {
        List<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        model.addAttribute("categories", categoryRepository.findAll());

        log.info("Return {} recipes from DB", recipes.size());
        return "index";
    }
}
