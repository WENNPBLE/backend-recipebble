package nl.novi.backendrecipebble.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    public Recipe() {
    }

    public Recipe(String name, String meal, Integer time, String difficulty, String cooking) {
        this.name = name;
        this.meal = meal;
        this.time = time;
        this.difficulty = difficulty;
        this.cooking = cooking;
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
}
