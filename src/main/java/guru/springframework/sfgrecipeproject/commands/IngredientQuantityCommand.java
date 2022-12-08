package guru.springframework.sfgrecipeproject.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientQuantityCommand {
    private Long id;
    private IngredientCommand ingredientCommand;
    private BigDecimal quantity;
    private UnitOfMeasureCommand unitOfMeasureCommand;
}
