

public class DataLoader {

    public static void loadSampleRecipes(RecipeBook book) {
        book.addRecipe(new Recipe(
            "Tomato Omelette",
            new String[]{"tomato", "egg", "onion"},
            "Indian",
            "vegetarian",
            "Easy",
            "Beat eggs, mix ingredients, cook on pan."
        ));

        book.addRecipe(new Recipe(
            "Egg Curry",
            new String[]{"egg", "onion", "tomato"},
            "Indian",
            "non-vegetarian",
            "Medium",
            "Boil eggs, prepare curry sauce, add eggs."
        ));

        book.addRecipe(new Recipe(
            "Avocado Toast",
            new String[]{"avocado", "bread"},
            "Continental",
            "vegan",
            "Easy",
            "Mash avocado, spread on toast."
        ));

        book.addRecipe(new Recipe(
            "Pasta Marinara",
            new String[]{"pasta", "tomato", "olive oil"},
            "Italian",
            "vegetarian",
            "Medium",
            "Boil pasta, cook sauce, mix."
        ));
    }
}