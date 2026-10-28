public class Recipe {
    private String name;
    private String[] ingredients;
    private String cuisine;
    private String dietary;
    private String difficulty;
    private String instructions;

    public Recipe(String name, String[] ingredients, String cuisine, String dietary, String difficulty, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.cuisine = cuisine;
        this.dietary = dietary;
        this.difficulty = difficulty;
        this.instructions = instructions;
    }

    public String getName() { return name; }
    public String[] getIngredients() { return ingredients; }
    public String getCuisine() { return cuisine; }
    public String getDietary() { return dietary; }
    public String getDifficulty() { return difficulty; }
    public String getInstructions() { return instructions; }

    public boolean matchesIngredients(String[] available) {
        for (String ingredient : ingredients) {
            boolean found = false;
            for (String avail : available) {
                if (ingredient.trim().equalsIgnoreCase(avail.trim())) {
                    found = true; break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    public String toString() {
        return "Recipe: " + name + "\nCuisine: " + cuisine + "\nDietary: " + dietary +
               "\nDifficulty: " + difficulty + "\nIngredients: " + String.join(", ", ingredients) +
               "\nInstructions: " + instructions + "\n";
    }
}