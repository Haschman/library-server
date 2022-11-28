package haschman.library_server.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "location")
public class Location implements DomainEntity<Long> {
    @Id
    @GeneratedValue
    @Column(name = "id_location")
    private Long id;
    @Column(nullable = false)
    private int stand;
    @Column(nullable = false)
    private int shelf;
    @OneToMany(mappedBy = "name")
    private Set<Book> books = new HashSet<>();

    public Location() {
    }

    public Location(Long id, int stand, int shelf, Set<Book> books) {
        this.id = id;
        this.stand = stand;
        this.shelf = shelf;
        this.books = books;
    }

    public Location(Long id, int stand, int shelf) {
        this.id = id;
        this.stand = stand;
        this.shelf = shelf;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStand() {
        return stand;
    }

    public void setStand(int stand) {
        this.stand = stand;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public Collection<Book> getBooks() {
        return Collections.unmodifiableCollection(books);
    }

    public void addBook(Book book) {
        books.add(Objects.requireNonNull(book));
    }
}
