package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.CategoryCommand;
import guru.springframework.sfgrecipeproject.commands.IngredientQuantityCommand;
import guru.springframework.sfgrecipeproject.commands.RecipeCommand;
import guru.springframework.sfgrecipeproject.domain.Notes;
import guru.springframework.sfgrecipeproject.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final NotesCommandToNotes notesConverter;
    private final IngredientQuantityCommandToIngredientQuantity ingredientConverter;
    private final CategoryCommandToCategory categoryConverter;

    public RecipeCommandToRecipe(NotesCommandToNotes notesConverter,
                                 IngredientQuantityCommandToIngredientQuantity ingredientConverter,
                                 CategoryCommandToCategory categoryConverter) {
        this.notesConverter = notesConverter;
        this.ingredientConverter = ingredientConverter;
        this.categoryConverter = categoryConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {

        if(source == null) return null;

        Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setTitle(source.getTitle());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setCookTime(source.getCookTime());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        Notes notes = notesConverter.convert(source.getNotes());
        recipe.setNotes(notes);
        recipe.setDirections(source.getDirections());
        recipe.setTimestamp(source.getTimestamp());
        recipe.setDifficulty(source.getDifficulty());

        List<IngredientQuantityCommand> ingredients = source.getIngredientsCommand();
        if(ingredients != null && ingredients.size() > 0) {
            ingredients.forEach(ingredientQuantity -> recipe.getIngredients().add(ingredientConverter.convert(ingredientQuantity)));
        }

        List<CategoryCommand> categories = source.getCategoriesCommand();
        if(categories != null && categories.size() > 0) {
            categories.forEach(category -> recipe.getCategories().add(categoryConverter.convert(category)));
        }

        return recipe;
    }
}
