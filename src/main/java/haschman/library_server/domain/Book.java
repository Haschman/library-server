package haschman.library_server.domain;

import javax.persistence.*;
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
    private Integer publication_year;
    @Column
    private String category;
    @Column
    private String genre;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "book_authors", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @ManyToOne(cascade = {CascadeType.ALL})
    private Location location;

    public Book() {
    }

    /**
     * Constructor
     * @param name required
     * @param language required
     * @param ISBN nullable
     * @param publication_year nullable
     * @param category nullable
     * @param genre nullable
     * @param authors required
     * @param location required
     */
    public Book(String name, String language, Long ISBN, Integer publication_year, String category, String genre, Set<Author> authors, Location location) {
        this.name = Objects.requireNonNull(name);
        this.language = Objects.requireNonNull(language);
        this.ISBN = ISBN;
        this.publication_year = publication_year;
        this.category = category;
        this.genre = genre;
        this.authors = Objects.requireNonNull(authors);
        //this.borrowings = borrowings;        this.location = Objects.requireNonNull(location);
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

    public Integer getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Integer publication_date) {
        this.publication_year = publication_date;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;

        return name.equals(book.name) && Objects.equals(language, book.language) && Objects.equals(ISBN, book.ISBN) && Objects.equals(publication_year, book.publication_year) && authors.equals(book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, language, ISBN, publication_year);
    }
}
