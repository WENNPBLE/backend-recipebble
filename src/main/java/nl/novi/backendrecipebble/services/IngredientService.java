package nl.novi.backendrecipebble.services;

import nl.novi.backendrecipebble.models.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredients();
    Ingredient getIngredientById(Long id);
    Ingredient saveIngredient(Ingredient ingredient);
    Ingredient updateIngredient(Ingredient ingredient, Long id);
    void deleteIngredient(Long id);
}
