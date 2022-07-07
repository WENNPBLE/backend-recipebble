package nl.novi.backendrecipebble.repositories;

import nl.novi.backendrecipebble.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
