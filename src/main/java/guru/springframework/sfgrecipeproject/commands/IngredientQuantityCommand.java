package guru.springframework.sfgrecipeproject.commands;

import guru.springframework.sfgrecipeproject.domain.Ingredient;
import guru.springframework.sfgrecipeproject.domain.Recipe;
import guru.springframework.sfgrecipeproject.domain.UnitOfMeasure;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientQuantityCommand {
    private Long id;
    private Ingredient ingredient;
    private BigDecimal quantity;
    private UnitOfMeasure unitOfMeasure;
    private Recipe recipe;
}
