package guru.springframework.sfgrecipeproject.controllers;

import guru.springframework.sfgrecipeproject.repository.CategoryRepository;
import guru.springframework.sfgrecipeproject.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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

        model.addAttribute("recipes", recipeService.getRecipes());
        model.addAttribute("categories", categoryRepository.findAll());


        return "index";
    }
}
