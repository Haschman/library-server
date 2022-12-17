package haschman.library_server.api.model;

import java.util.HashSet;
import java.util.Set;

public class BookDTO {
    private Long Id;
    private String name;
    private String language;
    private Long ISBN;
    private Integer publicationYear;
    private String category;
    private String genre;
    private Integer shelf;
    private Integer stand;
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

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publication_dateS) {
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

    public Integer getShelf() {
        return shelf;
    }

    public void setShelf(Integer shelf) {
        this.shelf = shelf;
    }

    public Integer getStand() {
        return stand;
    }

    public void setStand(Integer stand) {
        this.stand = stand;
    }

    public Set<Long> getAuthors() {
        return authors;
    }

    public void addAuthor(Long authorID) {
        authors.add(authorID);
    }
}
