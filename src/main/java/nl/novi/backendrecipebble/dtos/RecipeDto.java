package nl.novi.backendrecipebble.dtos;

public class RecipeDto {

    private Long id;
    private String name;
    private String meal;
    private Integer time;
    private String difficulty;
    private String cooking;
    private String uploadedBy;

    public RecipeDto() {
    }

    public RecipeDto(Long id, String name, String meal, Integer time, String difficulty, String cooking, String uploadedBy) {
        this.id = id;
        this.name = name;
        this.meal = meal;
        this.time = time;
        this.difficulty = difficulty;
        this.cooking = cooking;
        this.uploadedBy = uploadedBy;
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

    public String getUploadedBy() {
        return uploadedBy;
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

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }
}
