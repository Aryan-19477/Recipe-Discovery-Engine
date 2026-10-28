import java.util.*;

public class RecipeDiscoveryENgine {
    private static Scanner scanner = new Scanner(System.in);
    private static RecipeBook recipeBook = new RecipeBook();
    private static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        DataLoader.loadSampleRecipes(recipeBook);
        User currentUser = null;

        while (true) {
            System.out.println("\nWelcome to Smart Recipe Discovery Engine!");
            if (currentUser == null) {
                System.out.println("1. Register\n2. Login\n3. Exit\nChoose option:");
                int op = Integer.parseInt(scanner.nextLine());
                if (op == 3) break;
                System.out.print("Enter username: ");
                String username = scanner.nextLine().trim();

                if (op == 1) {
                    if (users.containsKey(username)) System.out.println("User exists!");
                    else {
                        users.put(username, new User(username));
                        System.out.println("Registration successful!");
                    }
                } else if (op == 2) {
                    if (users.containsKey(username)) {
                        currentUser = users.get(username);
                        System.out.println("Login successful!");
                    } else System.out.println("User not found. Please register.");
                }
                continue;
            }

            System.out.println("1. Browse All Recipes\n2. Search by Ingredients\n3. Filter by Cuisine\n4. Personalized Recommendations\n5. Add a Recipe\n6. Add Recipe to Favorites\n7. Show Favorites\n8. Logout\nChoose option:");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                for (Recipe r : recipeBook.getAllRecipes()) System.out.println(r);
            } else if (choice == 2) {
                System.out.print("Enter available ingredients (comma separated): ");
                String[] ing = scanner.nextLine().split(",");
                List<Recipe> matches = recipeBook.filterByIngredients(ing);
                if (matches.isEmpty()) System.out.println("No matching recipes.");
                else for (Recipe r : matches) System.out.println(r);
            } else if (choice == 3) {
                System.out.print("Enter cuisine: ");
                String cuisine = scanner.nextLine();
                List<Recipe> matches = recipeBook.filterByCuisine(cuisine);
                if (matches.isEmpty()) System.out.println("No matching recipes.");
                else for (Recipe r : matches) System.out.println(r);
            } else if (choice == 4) {
                RecommendationEngine engine = new RecommendationEngine(recipeBook);
                List<Recipe> recs = engine.recommendByHistory(currentUser);
                if (recs.isEmpty()) System.out.println("No recommendations yet.");
                else for (Recipe r : recs) System.out.println(r);
            } else if (choice == 5) {
                System.out.print("Recipe name: ");
                String name = scanner.nextLine().trim();
                System.out.print("Ingredients (comma separated): ");
                String[] ing = scanner.nextLine().split(",");
                System.out.print("Cuisine: ");
                String cuisine = scanner.nextLine().trim();
                System.out.print("Dietary (veg/vegan/non-veg): ");
                String dietary = scanner.nextLine().trim();
                System.out.print("Difficulty: ");
                String diff = scanner.nextLine().trim();
                System.out.print("Instructions: ");
                String instr = scanner.nextLine().trim();
                recipeBook.addRecipe(new Recipe(name, ing, cuisine, dietary, diff, instr));
                System.out.println("Recipe added!");
            } else if (choice == 6) {
                System.out.print("Enter recipe name to add to favorites: ");
                String name = scanner.nextLine().trim();
                if (recipeBook.getByName(name) != null) {
                    currentUser.addFavorite(name);
                    System.out.println("Added to favorites!");
                } else System.out.println("Recipe not found.");
            } else if (choice == 7) {
                Set<String> favs = currentUser.getFavorites();
                if (favs.isEmpty()) System.out.println("No favorites yet.");
                else for (String fav : favs) System.out.println(recipeBook.getByName(fav));
            } else if (choice == 8) {
                currentUser = null;
                System.out.println("Logged out!");
            }
        }
        System.out.println("Thank you for using!");
    }
}