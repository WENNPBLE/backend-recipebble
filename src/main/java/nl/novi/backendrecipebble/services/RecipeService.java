package nl.novi.backendrecipebble.services;

import nl.novi.backendrecipebble.models.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
    Recipe saveRecipe(Recipe recipe);
    Recipe updateRecipe(Recipe recipe, Long id);
    void deleteRecipe(Long id);
}
