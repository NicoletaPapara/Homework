package hotelmng.model.hotel;


import lombok.Getter;

@Getter
public enum MealPreference {

    REGULAR("can contain any type of ingredient", false),
    VEGETARIAN("doesn't contain meat, poultry, fish and shellfish", false),
    VEGAN("doesn't contain any ingredient derived from animals", true),
    GLUTENFREE("doesn't contain wheat, barley, rye or oats", true);

    private String message;
    private boolean preOrderRequired;

    MealPreference(String message, boolean preOrderRequired) {
        this.message = message;
        this.preOrderRequired = preOrderRequired;
    }
}
