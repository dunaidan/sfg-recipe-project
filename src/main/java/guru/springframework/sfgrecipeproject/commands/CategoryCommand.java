package guru.springframework.sfgrecipeproject.commands;

import guru.springframework.sfgrecipeproject.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCommand {
    private Long id;
    private String description;
    private List<Recipe> recipes;
}
