package haschman.library_server.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Location implements DomainEntity<Long> {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int stand;
    @Column(nullable = false)
    private int shelf;
    @OneToMany(mappedBy = "id")
    private Set<Book> books = new HashSet<>();

    public Location() {
    }

    public Location(Long id, int stand, int shelf) {
        this.id = id;
        this.stand = stand;
        this.shelf = shelf;
    }

    public Location(Long id, int stand, int shelf, Set<Book> books) {
        this.id = id;
        this.stand = stand;
        this.shelf = shelf;
        this.books = books;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return stand == location.stand && shelf == location.shelf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stand, shelf);
    }
}
