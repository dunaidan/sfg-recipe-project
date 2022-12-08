package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.UnitOfMeasureCommand;
import guru.springframework.sfgrecipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureCommandToUnitOfMeasureTest {
    public static final long ID = 1L;
    public static final String GRAMS = "grams";
    UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;
    UnitOfMeasureCommand unitOfMeasureCommand;

    @BeforeEach
    void setUp() {
        unitOfMeasureCommandToUnitOfMeasure = new UnitOfMeasureCommandToUnitOfMeasure();

        unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(ID);
        unitOfMeasureCommand.setName(GRAMS);
    }

    @Test
    void convert() {
        //given
        UnitOfMeasure unitOfMeasure;

        //when
        unitOfMeasure = unitOfMeasureCommandToUnitOfMeasure.convert(unitOfMeasureCommand);

        //then
        assertNotNull(unitOfMeasure);
        assertEquals(ID, unitOfMeasure.getId());
        assertEquals(GRAMS, unitOfMeasure.getName());
    }

    @Test
    void convertShouldReturnNull() {
        //given
        UnitOfMeasure unitOfMeasure;

        //when
        unitOfMeasure = unitOfMeasureCommandToUnitOfMeasure.convert(null);

        //then
        assertNull(unitOfMeasure);
    }
}