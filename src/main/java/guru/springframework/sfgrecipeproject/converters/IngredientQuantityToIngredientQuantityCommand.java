package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.IngredientCommand;
import guru.springframework.sfgrecipeproject.commands.IngredientQuantityCommand;
import guru.springframework.sfgrecipeproject.commands.UnitOfMeasureCommand;
import guru.springframework.sfgrecipeproject.domain.IngredientQuantity;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientQuantityToIngredientQuantityCommand implements Converter<IngredientQuantity, IngredientQuantityCommand> {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public IngredientQuantityToIngredientQuantityCommand(IngredientToIngredientCommand ingredientToIngredientCommand, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientQuantityCommand convert(IngredientQuantity source) {
        if(source == null) return null;

        IngredientQuantityCommand ingredientQuantityCommand = new IngredientQuantityCommand();
        ingredientQuantityCommand.setId(source.getId());

        IngredientCommand ingredientCommand = ingredientToIngredientCommand.convert(source.getIngredient());
        ingredientQuantityCommand.setIngredientCommand(ingredientCommand);

        UnitOfMeasureCommand unitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand.convert(source.getUnitOfMeasure());
        ingredientQuantityCommand.setUnitOfMeasureCommand(unitOfMeasureCommand);

        return ingredientQuantityCommand;
    }
}
