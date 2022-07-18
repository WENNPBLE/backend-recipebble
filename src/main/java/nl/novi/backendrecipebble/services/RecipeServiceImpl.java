package nl.novi.backendrecipebble.services;

import nl.novi.backendrecipebble.dtos.RecipeDto;
import nl.novi.backendrecipebble.exceptions.RecordNotFoundException;
import nl.novi.backendrecipebble.models.Recipe;
import nl.novi.backendrecipebble.models.RecipeIngredient;
import nl.novi.backendrecipebble.repositories.AccountRepository;
import nl.novi.backendrecipebble.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final AccountRepository accountRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository, AccountRepository accountRepository) {
        this.recipeRepository = recipeRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<RecipeDto> getAllRecipes() {
        List<RecipeDto> recipeDtos = new ArrayList<>();
        List<Recipe> recipes = recipeRepository.findAll();
        for (Recipe recipe : recipes) {
            RecipeDto recipeDto = transferRecipeToRecipeDto(recipe);
            recipeDtos.add(recipeDto);
        }
        return recipeDtos;
    }

    @Override
    public RecipeDto getRecipeById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            Recipe recipe1 = recipe.get();
            RecipeDto dto = transferRecipeToRecipeDto(recipe1);
            return dto;
        } else {
            throw new RecordNotFoundException("Could not find recipe");
        }
    }

    @Override
    public RecipeDto saveRecipe(RecipeDto recipeDto) {
        Recipe recipe = transferRecipeDtoToRecipe(recipeDto);

        Recipe recipe3 = recipeRepository.save(recipe);
        RecipeDto dto = transferRecipeToRecipeDto(recipe3);
        return dto;
    }

    @Override
    public RecipeDto updateRecipe(RecipeDto recipeDto, Long id) {
        Recipe recipe = transferRecipeDtoToRecipe(recipeDto);
        Recipe recipe2 = transferRecipe(recipe, id);
        recipeRepository.save(recipe2);
        RecipeDto dto = transferRecipeToRecipeDto(recipe2);
        return dto;
    }

    @Override
    public void deleteRecipe(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            recipeRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Could not delete recipe");
        }
    }

    public Recipe transferRecipe(Recipe recipe, Long id) {
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

    public RecipeDto transferRecipeToRecipeDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();

        recipeDto.setId(recipe.getId());
        recipeDto.setName(recipe.getName());
        recipeDto.setMeal(recipe.getMeal());
        recipeDto.setTime(recipe.getTime());
        recipeDto.setDifficulty(recipe.getDifficulty());
        recipeDto.setCooking(recipe.getCooking());
        recipeDto.setUploadedBy(recipe.getAccount().getName());
        return recipeDto;
    }

    public Recipe transferRecipeDtoToRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        recipe.setMeal(recipeDto.getMeal());
        recipe.setTime(recipeDto.getTime());
        recipe.setDifficulty(recipeDto.getDifficulty());
        recipe.setCooking(recipeDto.getCooking());
        recipe.setAccount(accountRepository.getAccountByNameEqualsIgnoreCase(recipeDto.getName()));
        return recipe;
    }

    public Recipe addRecipeIngredientToRecipeIngredientList(RecipeIngredient recipeIngredient, Long recipeId){
        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeId);
        if(optionalRecipe.isPresent()){
            Recipe recipe = optionalRecipe.get();
            List<RecipeIngredient> recipeIngredients = recipe.getRecipeIngredients();
            recipeIngredients.add(recipeIngredient);
            recipe.setRecipeIngredients(recipeIngredients);
            return recipeRepository.save(recipe);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
