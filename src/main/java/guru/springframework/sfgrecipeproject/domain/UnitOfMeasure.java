package guru.springframework.sfgrecipeproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class UnitOfMeasure extends BaseEntity {
    private String name;
}
