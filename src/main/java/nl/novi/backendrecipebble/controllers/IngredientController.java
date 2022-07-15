package nl.novi.backendrecipebble.controllers;
import nl.novi.backendrecipebble.dtos.IngredientDto;
import nl.novi.backendrecipebble.services.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<IngredientDto> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }

    @GetMapping("{id}")
    public IngredientDto getIngredientById(@PathVariable Long id){
        return ingredientService.getIngredientById(id);
    }

    @PostMapping
    public IngredientDto saveIngredient(@RequestBody IngredientDto ingredientDto){
        return ingredientService.saveIngredient(ingredientDto);
    }

    @PutMapping("{id}")
public IngredientDto updateIngredient(@PathVariable Long id, @RequestBody IngredientDto ingredientDto){
        return ingredientService.updateIngredient(ingredientDto, id);
    }

    @DeleteMapping("{id}")
    public void deleteIngredient(@PathVariable Long id){ingredientService.deleteIngredient(id);}
}
