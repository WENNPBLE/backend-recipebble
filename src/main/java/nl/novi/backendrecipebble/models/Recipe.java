package nl.novi.backendrecipebble.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String meal;
    private Integer time;
    private String difficulty;
    private String cooking;

@OneToMany (mappedBy = "recipe")
List<RecipeIngredient> recipeIngredients;

@ManyToOne
@JoinColumn(name = "account_recipe")
private Account account;


    public Recipe() {
    }

    public Recipe(Long id, String name, String meal, Integer time, String difficulty, String cooking) {
        this.id = id;
        this.name = name;
        this.meal = meal;
        this.time = time;
        this.difficulty = difficulty;
        this.cooking = cooking;
    }

    public Recipe(Long id, String name, String meal, Integer time, String difficulty, String cooking, List<RecipeIngredient> recipeIngredients, Account account) {
        this.id = id;
        this.name = name;
        this.meal = meal;
        this.time = time;
        this.difficulty = difficulty;
        this.cooking = cooking;
        this.recipeIngredients = recipeIngredients;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMeal() {
        return meal;
    }

    public Integer getTime() {
        return time;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getCooking() {
        return cooking;
    }

    public Account getAccount() {
        return account;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setCooking(String cooking) {
        this.cooking = cooking;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
