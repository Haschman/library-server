package haschman.library_server.domain;

import javax.persistence.*;
import java.util.*;

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
    @JoinTable(name = "book_authors", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();

    public Author() {
    }

    public Author(Long id, String name, String surname, String nationality, int century, Set<Book> books) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.surname = Objects.requireNonNull(surname);
        this.nationality = nationality;
        this.century = century;
        this.books = Objects.requireNonNull(books);
    }

    public Author(Long id, String name, String surname, String nationality, int century) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.century = century;
    }

    public Author(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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
