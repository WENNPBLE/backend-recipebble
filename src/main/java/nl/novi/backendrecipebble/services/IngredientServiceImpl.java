package nl.novi.backendrecipebble.services;


import nl.novi.backendrecipebble.dtos.IngredientDto;
import nl.novi.backendrecipebble.exceptions.RecordNotFoundException;
import nl.novi.backendrecipebble.models.Ingredient;
import nl.novi.backendrecipebble.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<IngredientDto> getAllIngredients() {
        List<IngredientDto> ingredientDtos = new ArrayList<>();
        List<Ingredient> ingredients = ingredientRepository.findAll();
        for (Ingredient ingredient : ingredients) {
            IngredientDto ingredientDto = transferIngredientToIngredientDto(ingredient);
            ingredientDtos.add(ingredientDto);
        }
        return ingredientDtos;
    }

    @Override
    public IngredientDto getIngredientById(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isPresent()) {
            Ingredient ingredient1 = ingredient.get();
            IngredientDto dto = transferIngredientToIngredientDto(ingredient1);
            return dto;
        } else {
            throw new RecordNotFoundException("Could not find ingredient");
        }
    }

    @Override
    public IngredientDto saveIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = transferIngredientDtoToIngredient(ingredientDto);
        Ingredient ingredient3 = ingredientRepository.save(ingredient);
        IngredientDto dto = transferIngredientToIngredientDto(ingredient3);
        return dto;
    }

    @Override
    public IngredientDto updateIngredient(IngredientDto ingredientDto, Long id) {
        Ingredient ingredient = transferIngredientDtoToIngredient(ingredientDto);
        Ingredient ingredient2 = transferIngredient(ingredient, id);
        ingredientRepository.save(ingredient2);
        IngredientDto dto = transferIngredientToIngredientDto(ingredient2);
        return dto;
    }

    @Override
    public void deleteIngredient(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isPresent()) {
            ingredientRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Could not delete ingredient");
        }
    }

    public Ingredient transferIngredient(Ingredient ingredient, Long id) {
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

    public IngredientDto transferIngredientToIngredientDto(Ingredient ingredient) {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setType(ingredient.getType());
        ingredientDto.setAmount(ingredient.getAmount());
        ingredientDto.setUnit(ingredient.getUnit());
        return ingredientDto;
    }

    public Ingredient transferIngredientDtoToIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDto.getName());
        ingredient.setType(ingredientDto.getType());
        ingredient.setAmount(ingredientDto.getAmount());
        ingredient.setUnit(ingredientDto.getUnit());
        return ingredient;
    }
}
