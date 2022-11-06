package haschman.library_server.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Vector;

@Entity
public class Location implements DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private int stand;
    @Column(nullable = false)
    private int shelf;
    @OneToMany
    private Vector<Book> books = new Vector<>();

    public Location() {
    }

    public Location(Long id, int stand, int shelf, Vector<Book> books) {
        this.id = id;
        if (stand < 0 || shelf < 0) throw new AssertionError();
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
}
