package guru.springframework.sfgrecipeproject.model;
import java.time.LocalDateTime;
import java.util.List;

public class Recipe extends BaseEntity {
    private String title;
    private String recipeText;
    private LocalDateTime timestamp;
    private MealType mealType;
    private List<Ingredient> ingredients;
    private List<Step> steps;

    public Recipe(String title, String recipeText, MealType mealType) {
        this.title = title;
        this.recipeText = recipeText;
        this.timestamp = LocalDateTime.now();
        this.mealType = mealType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRecipeText() {
        return recipeText;
    }

    public void setRecipeText(String recipeText) {
        this.recipeText = recipeText;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }
}
