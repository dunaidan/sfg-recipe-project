package guru.springframework.sfgrecipeproject.commands;

import guru.springframework.sfgrecipeproject.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotesCommand {
    private Long id;
    private Recipe recipe;
    private String recipeNotes;
}
