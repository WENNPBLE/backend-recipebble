package nl.novi.backendrecipebble.services;
import nl.novi.backendrecipebble.dtos.RecipeDto;


import java.util.List;

public interface RecipeService {
    List<RecipeDto> getAllRecipes();
    RecipeDto getRecipeById(Long id);
    RecipeDto saveRecipe(RecipeDto recipeDto);
    RecipeDto updateRecipe(RecipeDto recipeDto, Long id);
    void deleteRecipe(Long id);
}
