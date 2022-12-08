package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.NotesCommand;
import guru.springframework.sfgrecipeproject.commands.RecipeCommand;
import guru.springframework.sfgrecipeproject.domain.Category;
import guru.springframework.sfgrecipeproject.domain.IngredientQuantity;
import guru.springframework.sfgrecipeproject.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final NotesToNotesCommand noteToNotesCommand;
    private final IngredientQuantityToIngredientQuantityCommand ingredientQuantityToIngredientQuantityCommand;
    private final CategoryToCategoryCommand categoryToCategoryCommand;

    public RecipeToRecipeCommand(NotesToNotesCommand noteToNotesCommand,
                                 IngredientQuantityToIngredientQuantityCommand ingredientQuantityToIngredientQuantityCommand,
                                 CategoryToCategoryCommand categoryToCategoryCommand) {
        this.noteToNotesCommand = noteToNotesCommand;
        this.ingredientQuantityToIngredientQuantityCommand = ingredientQuantityToIngredientQuantityCommand;
        this.categoryToCategoryCommand = categoryToCategoryCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if(source == null) return null;

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(source.getId());
        recipeCommand.setTitle(source.getTitle());
        recipeCommand.setPrepTime(source.getPrepTime());
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setServings(source.getServings());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setUrl(source.getUrl());
        NotesCommand notesCommand = noteToNotesCommand.convert(source.getNotes());
        recipeCommand.setNotes(notesCommand);
        recipeCommand.setDirections(source.getDirections());
        recipeCommand.setTimestamp(source.getTimestamp());
        recipeCommand.setDifficulty(source.getDifficulty());

        List<IngredientQuantity> ingredientQuantityList = source.getIngredients();
        if(ingredientQuantityList != null && ingredientQuantityList.size() > 0) {
            ingredientQuantityList.forEach(ingredientQuantity -> recipeCommand.getIngredientsCommand().add(ingredientQuantityToIngredientQuantityCommand.convert(ingredientQuantity)));
        }

        List<Category> categoryList = source.getCategories();
        if(categoryList != null && categoryList.size() > 0) {
            categoryList.forEach(category -> recipeCommand.getCategoriesCommand().add(categoryToCategoryCommand.convert(category)));
        }

        return recipeCommand;
    }
}
