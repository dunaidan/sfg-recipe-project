package guru.springframework.sfgrecipeproject.commands;

import guru.springframework.sfgrecipeproject.domain.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeCommand {
    private Long id;
    private String title;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private NotesCommand notes;
    private String directions;
    private LocalDateTime timestamp;
    private List<IngredientQuantityCommand> ingredientsCommand = new ArrayList<>();
    private List<CategoryCommand> categoriesCommand = new ArrayList<>();
    private Difficulty difficulty;
}
