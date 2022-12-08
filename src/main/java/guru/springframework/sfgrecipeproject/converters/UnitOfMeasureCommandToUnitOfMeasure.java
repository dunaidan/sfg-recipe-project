package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.UnitOfMeasureCommand;
import guru.springframework.sfgrecipeproject.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if(source == null) return null;

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(source.getId());
        unitOfMeasure.setName(source.getName());
        return unitOfMeasure;
    }
}
