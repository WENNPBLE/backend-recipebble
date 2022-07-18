package nl.novi.backendrecipebble.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class RecipeIngredient {

    @EmbeddedId
    private RecipeIngredientKey id;

    private int amount;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

   @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public RecipeIngredient() {
    }

    public RecipeIngredient(RecipeIngredientKey id, int amount, Recipe recipe, Ingredient ingredient) {
        this.id = id;
        this.amount = amount;
        this.recipe = recipe;
        this.ingredient = ingredient;
    }

    public RecipeIngredientKey getId() {
        return id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(RecipeIngredientKey id) {
        this.id = id;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

