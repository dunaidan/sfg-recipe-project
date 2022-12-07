package guru.springframework.sfgrecipeproject.domain;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ingredient extends BaseEntity {
    private String name;
}
