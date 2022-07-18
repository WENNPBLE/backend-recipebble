package nl.novi.backendrecipebble.repositories;

import nl.novi.backendrecipebble.models.RecipeIngredient;
import nl.novi.backendrecipebble.models.RecipeIngredientKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository <RecipeIngredient, RecipeIngredientKey> {
    List <RecipeIngredient> findAllByRecipeId(Long recipeId);
    List <RecipeIngredient>findAllByIngredientId(Long ingredientId);
}
