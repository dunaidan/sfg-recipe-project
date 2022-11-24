package guru.springframework.sfgrecipeproject.model;

public class QuantityUnit extends BaseEntity {
    private String name;

    public QuantityUnit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
