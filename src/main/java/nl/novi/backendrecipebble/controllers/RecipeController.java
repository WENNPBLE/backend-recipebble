package nl.novi.backendrecipebble.controllers;

import nl.novi.backendrecipebble.dtos.RecipeDto;
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
    public List<RecipeDto> getAllRecipes(){
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public RecipeDto getRecipeById(@PathVariable Long id){
        return recipeService.getRecipeById(id);
    }

    @PostMapping
    public RecipeDto saveRecipe(@RequestBody RecipeDto recipeDto){
        return recipeService.saveRecipe(recipeDto);
    }

    @PutMapping("{id}")
    public RecipeDto updateRecipe(@PathVariable Long id, @RequestBody RecipeDto recipeDto){
        return recipeService.updateRecipe(recipeDto, id);
    }

    @DeleteMapping("{id}")
    public void deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);
    }
}
