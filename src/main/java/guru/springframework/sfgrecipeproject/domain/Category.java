package guru.springframework.sfgrecipeproject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category extends BaseEntity {
    private String description;
    @ManyToMany(mappedBy = "categories")
    private List<Recipe> recipes;
}