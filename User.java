import java.util.*;

public class User {
    private String username;
    private Set<String> favoriteRecipes;

    public User(String username) {
        this.username = username;
        this.favoriteRecipes = new HashSet<>();
    }

    public String getUsername() { return username; }
    public void addFavorite(String recipeName) { favoriteRecipes.add(recipeName); }
    public Set<String> getFavorites() { return favoriteRecipes; }
}