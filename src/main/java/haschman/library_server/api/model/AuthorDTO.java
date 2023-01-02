package haschman.library_server.api.model;


import jakarta.validation.constraints.NotNull;

public class AuthorDTO {
    private Long id;
    private String name;
    @NotNull
    private String surname;
    private String nationality;
    private Integer century;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getCentury() {
        return century;
    }

    public void setCentury(Integer century) {
        this.century = century;
    }
}
