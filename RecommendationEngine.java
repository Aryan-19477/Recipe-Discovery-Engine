import java.util.*;

public class RecommendationEngine {
    private RecipeBook recipeBook;

    public RecommendationEngine(RecipeBook recipeBook) {
        this.recipeBook = recipeBook;
    }

    public List<Recipe> recommendByHistory(User user) {
        List<Recipe> recommendations = new ArrayList<>();
        Set<String> favorites = user.getFavorites();
        for (Recipe r : recipeBook.getAllRecipes()) {
            for (String fav : favorites) {
                if (!r.getName().equalsIgnoreCase(fav)) {
                    Recipe favRecipe = recipeBook.getByName(fav);
                    if (favRecipe != null && r.getCuisine().equalsIgnoreCase(favRecipe.getCuisine())) {
                        recommendations.add(r);
                        break;
                    }
                }
            }
        }
        return recommendations;
    }
}