package guru.springframework.sfgrecipeproject.model;

public class Step extends BaseEntity {
    private String title;
    private String stepText;

    public Step(String title, String stepText) {
        this.title = title;
        this.stepText = stepText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStepText() {
        return stepText;
    }

    public void setStepText(String stepText) {
        this.stepText = stepText;
    }
}
