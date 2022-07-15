package nl.novi.backendrecipebble.dtos;

public class AccountDto {

    private Long id;
    private String name;
    private String lastname;
    private String description;

    public AccountDto(){

    }

    public AccountDto(Long id, String name, String lastname, String description){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
