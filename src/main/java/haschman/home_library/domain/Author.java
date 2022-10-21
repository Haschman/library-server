package haschman.home_library.domain;

public class Author {
    private long id;
    private String name;
    private String surname;
    private String nationality;
    private int century;

    public Author(long id, String name, String surname, String nationality, int century) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.century = century;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getCentury() {
        return century;
    }

    public void setCentury(int century) {
        this.century = century;
    }
}
