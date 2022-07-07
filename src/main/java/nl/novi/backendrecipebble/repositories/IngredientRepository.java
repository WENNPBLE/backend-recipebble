package nl.novi.backendrecipebble.repositories;

import nl.novi.backendrecipebble.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
