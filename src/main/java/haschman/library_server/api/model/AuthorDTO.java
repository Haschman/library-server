package haschman.library_server.api.model;

import java.util.Set;

public class AuthorDTO {
//    Long id;
    String name;
    String surname;
    String nationality;
    int century;

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

    public int getCentury() {
        return century;
    }

    public void setCentury(int century) {
        this.century = century;
    }
}
