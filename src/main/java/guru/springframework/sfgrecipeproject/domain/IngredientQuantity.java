package guru.springframework.sfgrecipeproject.domain;

import javax.persistence.*;
import java.math.BigDecimal;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
