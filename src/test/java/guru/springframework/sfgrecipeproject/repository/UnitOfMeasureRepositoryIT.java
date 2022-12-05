package guru.springframework.sfgrecipeproject.repository;

import guru.springframework.sfgrecipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByName() {
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByName("Teaspoon");
        assertEquals("Teaspoon", unitOfMeasureOptional.get().getName());
    }

    @Test
    void findByNameCup() {
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByName("Cup");
        assertEquals("Cup", unitOfMeasureOptional.get().getName());
    }
}