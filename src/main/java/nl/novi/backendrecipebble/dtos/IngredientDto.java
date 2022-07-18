package nl.novi.backendrecipebble.dtos;

public class IngredientDto {

    private Long id;
    private String name;
    private String type;
    private String unit;

    public IngredientDto() {
    }

    public IngredientDto(Long id, String name, String type, String unit) {
        this.id = id;
        this.name = name;
        this.type = type;

        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
