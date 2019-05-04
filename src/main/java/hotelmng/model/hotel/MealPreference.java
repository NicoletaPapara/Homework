package hotelmng.model.hotel;

public enum MealPreference {

    Regular ("can contain any type of ingredient", false),
    Vegetarian ("doesn't contain meat, poultry, fish and shellfish", false),
    Vegan ("doesn't contain any ingredient derived from animals", true),
    GlutenFree ("doesn't contain wheat, barley, rye or oats", true);

    private String message;
    private boolean preOrderRequired;

    MealPreference(String message, boolean preOrderRequired) {
        this.message = message;
        this.preOrderRequired = preOrderRequired;
    }

    public String getInfo (){
        return message;
    }

    public boolean isPreOrderRequired(){
        return preOrderRequired;
    }
}
