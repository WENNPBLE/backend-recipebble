package nl.novi.backendrecipebble.controllers;

import nl.novi.backendrecipebble.dtos.RecipeIngredientDto;
import nl.novi.backendrecipebble.dtos.RecipeIngredientOutputDto;
import nl.novi.backendrecipebble.models.RecipeIngredient;
import nl.novi.backendrecipebble.services.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipeIngredients")
public class RecipeIngredientController {
    private final RecipeIngredientService recipeIngredientService;

    public RecipeIngredientController(RecipeIngredientService recipeIngredientService){
        this.recipeIngredientService = recipeIngredientService;
    }

 @GetMapping("/{recipeId}/{ingredientId}")
    public RecipeIngredientOutputDto getRecipeIngredientById(@PathVariable  Long recipeId,@PathVariable Long ingredientId){
      return   recipeIngredientService.getRecipeIngredientById(recipeId, ingredientId);

 }

     @GetMapping("/ingredients/{recipeId}")
     public List <RecipeIngredientOutputDto> getRecipeIngredientsByRecipeId(@PathVariable  Long recipeId){
        return  recipeIngredientService.getRecipeIngredientsByRecipeId( recipeId);
     }

         @GetMapping("/recipes/{ingredientId}")
         public List <RecipeIngredientOutputDto> getRecipeIngredientsByIngredientId(@PathVariable Long ingredientId){
           return recipeIngredientService.getRecipeIngredientsByIngredientId( ingredientId);
         }

         @PostMapping
    public RecipeIngredientOutputDto createRecipeIngredient(@RequestBody RecipeIngredientDto dto){
      return  recipeIngredientService.createRecipeIngredient(dto);
         }

         @PutMapping("/{recipeId}/{ingredientId}")
    public void updateRecipeIngredient(@PathVariable Long recipeId, @PathVariable Long ingredientId ,@RequestBody RecipeIngredientDto dto){
        recipeIngredientService.updateRecipeIngredient(recipeId, ingredientId, dto);
         }

//         @DeleteMapping("{recipeId}/{ingredientId}")
//    public void deleteRecipeIngredientById(@PathVariable Long recipeId, @PathVariable Long ingredientId){
//        recipeIngredientService.deleteRecipeIngredient(recipeId, ingredientId);
//         }
 }

