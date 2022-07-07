package nl.novi.backendrecipebble.controllers;

import nl.novi.backendrecipebble.models.Recipe;
import nl.novi.backendrecipebble.services.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id){
        return recipeService.getRecipeById(id);
    }

    @PostMapping
    public Recipe saveRecipe(@RequestBody Recipe recipe){
        return recipeService.saveRecipe(recipe);
    }

    @PutMapping("{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe){
        return recipeService.updateRecipe(recipe, id);
    }

    @DeleteMapping("{id}")
    public void deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);
    }
}
