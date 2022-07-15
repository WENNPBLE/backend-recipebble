package nl.novi.backendrecipebble.dtos;

public class IngredientDto {

    private Long id;
    private String name;
    private String type;
    private Integer amount;
    private String unit;

    public IngredientDto() {
    }

    public IngredientDto(Long id, String name, String type, Integer amount, String unit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.amount = amount;
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

    public Integer getAmount() {
        return amount;
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

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
