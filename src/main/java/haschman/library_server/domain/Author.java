package haschman.library_server.domain;

import java.util.Objects;

public class Author implements DomainEntity<Long> {
    private Long id;
    private String name;
    private String surname;
    private String nationality;
    private int century;
    private Book book;

    public Author() {
    }

    public Author(Long id, String name, String surname, String nationality, int century, Book book) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.surname = Objects.requireNonNull(surname);
        this.nationality = nationality;
        this.century = century;
        this.book = Objects.requireNonNull(book);
    }

    @Override
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
