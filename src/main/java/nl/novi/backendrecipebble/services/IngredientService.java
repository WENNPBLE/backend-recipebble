package nl.novi.backendrecipebble.services;
import nl.novi.backendrecipebble.dtos.IngredientDto;


import java.util.List;

public interface IngredientService {
    List<IngredientDto> getAllIngredients();
    IngredientDto getIngredientById(Long id);
    IngredientDto saveIngredient(IngredientDto ingredientDto);
    IngredientDto updateIngredient(IngredientDto ingredientDto, Long id);
    void deleteIngredient(Long id);
}
