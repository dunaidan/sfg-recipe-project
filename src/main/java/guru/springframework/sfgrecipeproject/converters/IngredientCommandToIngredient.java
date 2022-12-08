package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.IngredientCommand;
import guru.springframework.sfgrecipeproject.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if(source == null) return null;

        Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setName(source.getName());

        return ingredient;
    }
}
