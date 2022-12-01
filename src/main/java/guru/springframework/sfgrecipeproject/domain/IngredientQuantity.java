package guru.springframework.sfgrecipeproject.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@EqualsAndHashCode(exclude = {"ingredient", "unitOfMeasure"})
@Entity
public class IngredientQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
    private BigDecimal quantity;
    @ManyToOne
    @JoinColumn(name = "unitofmeasure_id")
    private UnitOfMeasure unitOfMeasure;
    @ManyToOne
    private Recipe recipe;

    public IngredientQuantity() {
    }

    public IngredientQuantity(Ingredient ingredient, BigDecimal quantity, UnitOfMeasure unitOfMeasure, Recipe recipe) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
        recipe.getIngredients().add(this);
    }
}
