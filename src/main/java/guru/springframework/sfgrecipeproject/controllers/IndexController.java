package guru.springframework.sfgrecipeproject.controllers;

import guru.springframework.sfgrecipeproject.domain.Category;
import guru.springframework.sfgrecipeproject.domain.UnitOfMeasure;
import guru.springframework.sfgrecipeproject.repository.CategoryRepository;
import guru.springframework.sfgrecipeproject.repository.UnitOfMeasureRepository;
import guru.springframework.sfgrecipeproject.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","index.html", "index"})
    public String getRecipes(Model model) {

        model.addAttribute("recipes", recipeService.getRecipes());


        return "index";
    }
}
