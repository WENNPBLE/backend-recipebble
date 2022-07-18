package nl.novi.backendrecipebble.dtos;

public class RecipeIngredientDto {

    private Long recipeId;
    private Long ingredientId;
    private int amount;

    public RecipeIngredientDto(Long recipeId, Long ingredientId, int amount) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.amount = amount;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public int getAmount() {
        return amount;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
