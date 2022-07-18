package nl.novi.backendrecipebble.dtos;

public class RecipeIngredientOutputDto {

    private String recipeName;
    private String ingredientName;
    private int amount;

    public RecipeIngredientOutputDto() {
    }

    public RecipeIngredientOutputDto(String recipeName, String ingredientName, int amount) {
        this.recipeName = recipeName;
        this.ingredientName = ingredientName;
        this.amount = amount;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getAmount() {
        return amount;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
