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
    @JoinColumn(name = "quantityunit_id")
    private QuantityUnit quantityUnit;
    @ManyToOne
    private Recipe recipe;
}
