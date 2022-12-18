package haschman.library_server.domain;

import jakarta.persistence.*;

import java.time.Year;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book implements DomainEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String language;
    @Column
    private Long ISBN;
    @Column(name = "publication_year")
    private Year publicationYear;
    @Column
    private String category;
    @Column
    private String genre;

    @ManyToMany
    @JoinTable(name = "book_authors", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Book() {
    }

    /**
     * Constructor
     * @param name required
     * @param language required
     * @param ISBN nullable
     * @param publicationYear nullable
     * @param category nullable
     * @param genre nullable
     * @param authors required
     * @param location required
     */
    public Book(Long id, String name, String language, Long ISBN, Year publicationYear, String category, String genre, Set<Author> authors, Location location) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.language = Objects.requireNonNull(language);
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.category = category;
        this.genre = genre;
        this.authors = Objects.requireNonNull(authors);
        this.location = location;
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

    public Year getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Year publication_date) {
        this.publicationYear = publication_date;
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

        return name.equals(book.name) && Objects.equals(language, book.language) && Objects.equals(ISBN, book.ISBN) && Objects.equals(publicationYear, book.publicationYear) && authors.equals(book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, language, ISBN, publicationYear);
    }
}
