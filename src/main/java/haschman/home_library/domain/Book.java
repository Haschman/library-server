package haschman.home_library.domain;

import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Vector;

public class Book implements DomainEntity<Long>{
    private Long id;
    private String name;
    private String language;

    private Long ISBN;
    private SimpleDateFormat publication_date;
    private String category;
    private String genre;

    private Vector<Author> authors;
    private Vector<Borrowing> borrowings;
    private Location location;

    public Book() {
    }

    /**
     * Constructor
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
    public Book(Long id, String name, String language, Long ISBN, SimpleDateFormat publication_date, String category, String genre, Vector<Author> authors, Vector<Borrowing> borrowings, Location location) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.ISBN = ISBN;
        this.publication_date = publication_date;
        this.category = category;
        this.genre = genre;
        this.authors = Objects.requireNonNull(authors);
        this.borrowings = borrowings;
        this.location = Objects.requireNonNull(location);
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

    public SimpleDateFormat getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(SimpleDateFormat publication_date) {
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

    public Vector<Author> getAuthor() {
        return authors;
    }

    public void setAuthor(Author author) {
        authors.add(Objects.requireNonNull(author));
    }

    public Vector<Borrowing> getBorrowings() {
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
