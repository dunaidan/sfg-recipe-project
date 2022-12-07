package guru.springframework.sfgrecipeproject.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class IngredientQuantity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
    private BigDecimal quantity;
    @ManyToOne
    @JoinColumn(name = "unitofmeasure_id")
    private UnitOfMeasure unitOfMeasure;
    @ManyToOne
    private Recipe recipe;

    public IngredientQuantity(Ingredient ingredient, BigDecimal quantity, UnitOfMeasure unitOfMeasure, Recipe recipe) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
        recipe.getIngredients().add(this);
    }
}
