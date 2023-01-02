package haschman.library_server.api.model;

import jakarta.validation.constraints.*;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class BookDTO {
    private Long Id;
    @NotNull
    private String name;
    @NotNull
    private String language;

    // ISBN should be 0 or something between 10 and 20 - custom constraint maybe?
    @Size(max = 20)
    private String ISBN;
    @PastOrPresent
    private Year publicationYear;
    private String category;
    private String genre;
    @NotNull
    private Long location;
    private final Set<Long> authors = new HashSet<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public @PastOrPresent Year getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Year publication_dateS) {
        this.publicationYear = publication_dateS;
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

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    public Set<Long> getAuthors() {
        return authors;
    }

    public void addAuthor(Long authorID) {
        authors.add(authorID);
    }
}
