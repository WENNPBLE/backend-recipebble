package nl.novi.backendrecipebble.services;

import nl.novi.backendrecipebble.exceptions.RecordNotFoundException;
import nl.novi.backendrecipebble.models.Recipe;
import nl.novi.backendrecipebble.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService{

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            return recipe.get();
        } else {
            throw new RecordNotFoundException("Could not find recipe");
        }
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe, Long id) {
       Recipe recipe2 = transferRecipe(recipe, id);
        return recipeRepository.save(recipe2);
    }

    @Override
    public void deleteRecipe(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(recipe.isPresent()){
            recipeRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Could not delete recipe");
        }
    }

    public Recipe transferRecipe(Recipe recipe, Long id){
        Optional<Recipe> recipe1 = recipeRepository.findById(id);
        if (recipe1.isPresent()) {
            Recipe recipe2 = recipe1.get();
            recipe2.setId(recipe2.getId());
            recipe2.setName(recipe.getName());
            recipe2.setMeal(recipe.getMeal());
            recipe2.setTime(recipe.getTime());
            recipe2.setDifficulty(recipe.getDifficulty());
            recipe2.setCooking(recipe.getCooking());
            return recipe2;
        } else {
            throw new RecordNotFoundException("Could not update recipe");
        }
    }
}
