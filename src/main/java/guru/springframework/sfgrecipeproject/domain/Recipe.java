package guru.springframework.sfgrecipeproject.domain;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private Byte[] image;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    @Lob
    private String directions;
    private LocalDateTime timestamp;
    @OneToMany(cascade = CascadeType.ALL)
    private List<IngredientQuantity> ingredients = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    public Recipe() {
        this.timestamp = LocalDateTime.now();
    }

    public Notes addNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);

        return notes;
    }
}
