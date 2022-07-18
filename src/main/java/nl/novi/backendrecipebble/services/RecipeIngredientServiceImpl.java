package nl.novi.backendrecipebble.services;

import nl.novi.backendrecipebble.dtos.RecipeIngredientDto;
import nl.novi.backendrecipebble.dtos.RecipeIngredientOutputDto;
import nl.novi.backendrecipebble.exceptions.RecordNotFoundException;
import nl.novi.backendrecipebble.models.Ingredient;
import nl.novi.backendrecipebble.models.Recipe;
import nl.novi.backendrecipebble.models.RecipeIngredient;
import nl.novi.backendrecipebble.models.RecipeIngredientKey;
import nl.novi.backendrecipebble.repositories.IngredientRepository;
import nl.novi.backendrecipebble.repositories.RecipeIngredientRepository;
import nl.novi.backendrecipebble.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService{

    private final RecipeIngredientRepository recipeIngredientRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final RecipeServiceImpl recipeService;

    public RecipeIngredientServiceImpl(RecipeIngredientRepository recipeIngredientRepository, RecipeRepository recipeRepository, IngredientRepository ingredientRepository, RecipeServiceImpl recipeService){
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeService = recipeService;
    }
    @Override
    public RecipeIngredientOutputDto getRecipeIngredientById(Long recipeId, Long ingredientId) {
        RecipeIngredientKey id = new RecipeIngredientKey(recipeId, ingredientId);
        Optional<RecipeIngredient> optionalRecipeIngredient =recipeIngredientRepository.findById(id);
        if(optionalRecipeIngredient.isPresent()){
        RecipeIngredient recipeIngredient =optionalRecipeIngredient.get();
        return transferRecipeIngredientToOutputDto(recipeIngredient);
        } else {
            throw new RecordNotFoundException("RecipeIngredient was not found");
        }
    }

    @Override
    public List<RecipeIngredientOutputDto> getRecipeIngredientsByRecipeId(Long recipeId) {
        List<RecipeIngredientOutputDto> outputDtos = new ArrayList<>();
        List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findAllByRecipeId(recipeId);
        for (RecipeIngredient recipeIngredient : recipeIngredients ) {
            RecipeIngredientOutputDto dto = transferRecipeIngredientToOutputDto(recipeIngredient);
            outputDtos.add(dto);
        }
        return outputDtos;
    }

    @Override
    public List<RecipeIngredientOutputDto> getRecipeIngredientsByIngredientId(Long ingredientId) {
        List<RecipeIngredientOutputDto> outputDtos = new ArrayList<>();
        List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findAllByIngredientId(ingredientId);
        for (RecipeIngredient recipeIngredient: recipeIngredients) {
            RecipeIngredientOutputDto dto = transferRecipeIngredientToOutputDto(recipeIngredient);
            outputDtos.add(dto);
        }
        return outputDtos;
    }

    @Override
    public RecipeIngredientOutputDto createRecipeIngredient(RecipeIngredientDto dto) {
        RecipeIngredient recipeIngredient = transferDtoToRecipeIngredient(dto);
        RecipeIngredient savedRecipeIngredient =  recipeIngredientRepository.save(recipeIngredient);
        RecipeIngredientOutputDto outputDto = transferRecipeIngredientToOutputDto(savedRecipeIngredient);
        return outputDto;
    }

    @Override
    public void updateRecipeIngredient(Long recipeId, Long ingredientId,  RecipeIngredientDto dto) {
        RecipeIngredientKey key = new RecipeIngredientKey(recipeId, ingredientId);
        Optional<RecipeIngredient> optionalRecipeIngredient= recipeIngredientRepository.findById(key);
        if(optionalRecipeIngredient.isPresent()){
            RecipeIngredient recipeIngredient1 = optionalRecipeIngredient.get();
            RecipeIngredient recipeIngredient = transferDtoToRecipeIngredient(dto);
            recipeIngredient1.setId(recipeIngredient1.getId());
            recipeIngredient1.setRecipe(recipeIngredient.getRecipe());
            recipeIngredient1.setIngredient(recipeIngredient.getIngredient());
            recipeIngredient1.setAmount(recipeIngredient.getAmount());
            recipeIngredientRepository.save(recipeIngredient1);
        } else {
            throw new RecordNotFoundException("Record could not be found");
        }
    }

    public RecipeIngredient transferDtoToRecipeIngredient(RecipeIngredientDto dto){
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(dto.getIngredientId());
        Optional<Recipe> optionalRecipe = recipeRepository.findById(dto.getRecipeId());
        if(optionalIngredient.isPresent() && optionalRecipe.isPresent()){
            recipeIngredient.setId(new RecipeIngredientKey(dto.getRecipeId(), dto.getIngredientId()));
            recipeIngredient.setIngredient(optionalIngredient.get());
            recipeIngredient.setRecipe(optionalRecipe.get());
            recipeIngredient.setAmount(dto.getAmount());
            recipeIngredientRepository.save(recipeIngredient);
            recipeService.addRecipeIngredientToRecipeIngredientList(recipeIngredient, dto.getRecipeId());
            return recipeIngredient;
        } else {
            throw new RecordNotFoundException("one of the records could not be found");
        }
    }

    public RecipeIngredientOutputDto transferRecipeIngredientToOutputDto(RecipeIngredient savedRecipeIngredient){
        RecipeIngredientOutputDto dto = new RecipeIngredientOutputDto();
        dto.setRecipeName(savedRecipeIngredient.getRecipe().getName());
        dto.setIngredientName(savedRecipeIngredient.getIngredient().getName());
        dto.setAmount(savedRecipeIngredient.getAmount());
        return dto;
    }
}
