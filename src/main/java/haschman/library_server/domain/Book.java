package haschman.library_server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.util.Pair;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book implements DomainEntity<Long>{
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String language;
    @Column
    private Long ISBN;
    @Column
    private Date publication_date;
    @Column
    private String category;
    @Column
    private String genre;

    @ManyToMany
    private Set<Author> authors = new HashSet<>();
    @OneToMany
    private Set<Borrowing> borrowings = new HashSet<>();
    @ManyToOne
    @JoinColumn(name="id_location")
    private Location location;

    public Book() {
    }

    /**
     * Constructor
     * @param id required
     * @param name required
     * @param language required
     * @param ISBN nullable
     * @param publication_date nullable
     * @param category nullable
     * @param genre nullable
     * @param authors required
     * @param borrowings nullable
     * @param location required
     */
    public Book(Long id, String name, String language, Long ISBN, Date publication_date, String category, String genre, Set<Author> authors, Set<Borrowing> borrowings, Location location) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.language = Objects.requireNonNull(language);
        this.ISBN = ISBN;
        this.publication_date = publication_date;
        this.category = category;
        this.genre = genre;
        this.authors = Objects.requireNonNull(authors);
        this.borrowings = borrowings;
        this.location = Objects.requireNonNull(location);
    }

    // Without borrowings
    public Book(Long id, String name, String language, Long ISBN, Date publication_date, String category, String genre, Set<Author> authors, Location location) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.language = Objects.requireNonNull(language);
        this.ISBN = ISBN;
        this.publication_date = publication_date;
        this.category = category;
        this.genre = genre;
        this.authors = Objects.requireNonNull(authors);
        this.location = Objects.requireNonNull(location);
    }

    public Book(Long id, String name, String language, Long ISBN, Date publication_date, String category, String genre) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.language = Objects.requireNonNull(language);
        this.ISBN = ISBN;
        this.publication_date = publication_date;
        this.category = category;
        this.genre = genre;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Author> getAuthor() {
        return authors;
    }

    public void addAuthor(Author author) {
        authors.add(Objects.requireNonNull(author));
    }

    public Set<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void addBorrowing (Borrowing borrowing) {
        borrowings.add(Objects.requireNonNull(borrowing));
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
