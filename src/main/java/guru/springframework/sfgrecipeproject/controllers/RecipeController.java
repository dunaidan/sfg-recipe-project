package guru.springframework.sfgrecipeproject.controllers;

import guru.springframework.sfgrecipeproject.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","index.html"})
    public String getRecipes(Model model) {

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
