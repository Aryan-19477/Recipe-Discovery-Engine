import java.util.*;

public class RecipeBook {
    private List<Recipe> recipes;

    public RecipeBook() {
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) { recipes.add(recipe); }

    public List<Recipe> filterByIngredients(String[] available) {
        List<Recipe> found = new ArrayList<>();
        for (Recipe r : recipes) {
            if (r.matchesIngredients(available)) found.add(r);
        }
        return found;
    }

    public List<Recipe> filterByCuisine(String cuisine) {
        List<Recipe> found = new ArrayList<>();
        for (Recipe r : recipes) {
            if (r.getCuisine().equalsIgnoreCase(cuisine)) found.add(r);
        }
        return found;
    }

    public Recipe getByName(String name) {
        for (Recipe r : recipes)
            if (r.getName().equalsIgnoreCase(name)) return r;
        return null;
    }

    public List<Recipe> getAllRecipes() { return recipes; }
}
