package nl.novi.backendrecipebble.services;


import nl.novi.backendrecipebble.exceptions.RecordNotFoundException;
import nl.novi.backendrecipebble.models.Ingredient;
import nl.novi.backendrecipebble.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;

    public  IngredientServiceImpl(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
       if(ingredient.isPresent()) {
           return ingredient.get();
       } else{
           throw new RecordNotFoundException("Could not find ingredient");
       }
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredient, Long id) {
        Ingredient ingredient2 = transferIngredient(ingredient, id);
        return ingredientRepository.save(ingredient2);
    }

    @Override
    public void deleteIngredient(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if(ingredient.isPresent()){
            ingredientRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Could not delete ingredient");
        }
    }

    public Ingredient transferIngredient(Ingredient ingredient, Long id){
        Optional<Ingredient> ingredient1 = ingredientRepository.findById(id);
        if (ingredient1.isPresent()) {
            Ingredient ingredient2 = ingredient1.get();
            ingredient2.setId(ingredient2.getId());
            ingredient2.setName(ingredient.getName());
           ingredient2.setType(ingredient.getType());
            ingredient2.setAmount(ingredient.getAmount());
            ingredient2.setUnit(ingredient.getUnit());
            return ingredient2;
        } else {
            throw new RecordNotFoundException("Could not update ingredient");
        }
    }
}
