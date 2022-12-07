package guru.springframework.sfgrecipeproject.commands;

import guru.springframework.sfgrecipeproject.domain.Category;
import guru.springframework.sfgrecipeproject.domain.Difficulty;
import guru.springframework.sfgrecipeproject.domain.IngredientQuantity;
import guru.springframework.sfgrecipeproject.domain.Notes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RecipeCommand {
    private Long id;
    private String title;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private Notes notes;
    private String directions;
    private LocalDateTime timestamp;
    private List<IngredientQuantity> ingredients = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private Difficulty difficulty;
}
