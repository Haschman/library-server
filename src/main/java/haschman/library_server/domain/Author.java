package haschman.library_server.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Vector;

@Entity
public class Author implements DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column
    private String nationality;
    @Column
    private int century;
    @ManyToMany
    private Vector<Book> books = new Vector<>();

    public Author() {
    }

    public Author(Long id, String name, String surname, String nationality, int century, Vector<Book> books) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.surname = Objects.requireNonNull(surname);
        this.nationality = nationality;
        this.century = century;
        this.books = Objects.requireNonNull(books);
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

    public Collection<Book> getBooks() {
        return Collections.unmodifiableCollection(books);
    }

    public void addBook(Book book) {
        books.add(Objects.requireNonNull(book));
    }
}
