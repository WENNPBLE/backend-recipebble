package nl.novi.backendrecipebble.services;


import nl.novi.backendrecipebble.dtos.RecipeIngredientDto;
import nl.novi.backendrecipebble.dtos.RecipeIngredientOutputDto;

import java.util.List;

public interface RecipeIngredientService {

    RecipeIngredientOutputDto getRecipeIngredientById(Long recipeId, Long ingredientId);

    List <RecipeIngredientOutputDto> getRecipeIngredientsByRecipeId(Long recipeId);

    List <RecipeIngredientOutputDto> getRecipeIngredientsByIngredientId(Long ingredientId);

    RecipeIngredientOutputDto createRecipeIngredient(RecipeIngredientDto dto);

    void updateRecipeIngredient(Long recipeId, Long ingredientId,  RecipeIngredientDto dto);

}
