package guru.springframework.sfgrecipeproject.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Data
@Entity
public class Ingredient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }
}
