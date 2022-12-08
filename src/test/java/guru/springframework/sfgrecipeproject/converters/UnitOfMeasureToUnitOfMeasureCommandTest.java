package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.UnitOfMeasureCommand;
import guru.springframework.sfgrecipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final long ID = 1L;
    public static final String GRAMS = "grams";
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;
    UnitOfMeasure unitOfMeasure;

    @BeforeEach
    void setUp() {
        unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();

        unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID);
        unitOfMeasure.setName(GRAMS);
    }

    @Test
    void convert() {
        //given
        UnitOfMeasureCommand unitOfMeasureCommand;

        //when
        unitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand.convert(unitOfMeasure);

        //then
        assertNotNull(unitOfMeasureCommand);
        assertEquals(ID, unitOfMeasureCommand.getId());
        assertEquals(GRAMS, unitOfMeasureCommand.getName());
    }

    @Test
    void convertShouldReturnNull() {
        //given
        UnitOfMeasureCommand unitOfMeasureCommand;

        //when
        unitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand.convert(null);

        //then
        assertNull(unitOfMeasureCommand);
    }

}