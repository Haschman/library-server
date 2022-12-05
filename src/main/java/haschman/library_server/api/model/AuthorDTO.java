package haschman.library_server.api.model;

import java.util.Set;

public class AuthorDTO {
    Long id;
    String name;
    String surname;
    String nationality;
    int century;

    Set<String> books;

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

    public int getCentury() {
        return century;
    }

    public void setCentury(int century) {
        this.century = century;
    }

    public Set<String> getBooks() {
        return books;
    }

    public void addBook(String book) {
        this.books.add(book);
    }
}
