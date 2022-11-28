package guru.springframework.sfgrecipeproject.controllers;

import guru.springframework.sfgrecipeproject.domain.Ingredient;
import guru.springframework.sfgrecipeproject.service.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping({"/ingredients", "/ingredients/index"})
    public String getIngredients(Model model) {

        model.addAttribute("ingredients", ingredientService.getIngredients());

        return "ingredients/index";
    }

    @GetMapping("/ingredients/add")
    public String addIngredient(Model model) {

        model.addAttribute("ingredient", new Ingredient());

        return "ingredients/add";
    }

    @PostMapping("/ingredients/add")
    public String addIngredient(@ModelAttribute Ingredient ingredient, Model model) {

        model.addAttribute("ingredient", ingredient);
        ingredientService.save(ingredient);

        return "ingredients/result";
    }

    @GetMapping("/ingredients/delete/{id}")
    public String addIngredient(@PathVariable Long id) {

        ingredientService.deleteById(id);

        return "ingredients/result";
    }

}
