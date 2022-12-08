package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.IngredientQuantityCommand;
import guru.springframework.sfgrecipeproject.domain.IngredientQuantity;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientQuantityCommandToIngredientQuantity implements Converter<IngredientQuantityCommand, IngredientQuantity> {

    private final IngredientCommandToIngredient ingredientConverter;
    private final UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter;

    public IngredientQuantityCommandToIngredientQuantity(IngredientCommandToIngredient ingredientConverter, UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter) {
        this.ingredientConverter = ingredientConverter;
        this.unitOfMeasureConverter = unitOfMeasureConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientQuantity convert(IngredientQuantityCommand source) {

        if(source == null) return null;

        IngredientQuantity ingredientQuantity = new IngredientQuantity();
        ingredientQuantity.setId(source.getId());
        ingredientQuantity.setIngredient(ingredientConverter.convert(source.getIngredientCommand()));
        ingredientQuantity.setUnitOfMeasure(unitOfMeasureConverter.convert(source.getUnitOfMeasureCommand()));

        return ingredientQuantity;
    }
}
