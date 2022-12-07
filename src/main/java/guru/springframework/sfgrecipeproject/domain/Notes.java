package guru.springframework.sfgrecipeproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Notes extends BaseEntity {
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;
}
