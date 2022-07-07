package nl.novi.backendrecipebble.controllers;
import nl.novi.backendrecipebble.models.Ingredient;
import nl.novi.backendrecipebble.services.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }

    @GetMapping("{id}")
    public Ingredient getIngredientById(@PathVariable Long id){
        return ingredientService.getIngredientById(id);
    }

    @PostMapping
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient){
        return ingredientService.saveIngredient(ingredient);
    }

    @PutMapping("{id}")
public Ingredient updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient){
        return ingredientService.updateIngredient(ingredient, id);
    }

    @DeleteMapping("{id}")
    public void deleteIngredient(@PathVariable Long id){ingredientService.deleteIngredient(id);}
}
