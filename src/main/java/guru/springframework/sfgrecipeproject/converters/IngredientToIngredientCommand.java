package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.IngredientCommand;
import guru.springframework.sfgrecipeproject.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if(source == null) return null;

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setName(source.getName());

        return ingredientCommand;
    }
}
