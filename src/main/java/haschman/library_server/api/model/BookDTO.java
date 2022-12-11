package haschman.library_server.api.model;

import org.springframework.data.util.Pair;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BookDTO {
    private String name;
    private String language;
    private Long ISBN;
    private Integer publication_year;
    private String category;
    private String genre;
    private Pair<Integer, Integer> location;
    private final Set<AuthorDTO> authors = new HashSet<>();

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

    public void setPublication_year(Integer publication_dateS) {
        this.publication_year = publication_dateS;
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

    public Pair<Integer, Integer> getLocation() {
        return location;
    }

    public void setLocation(int stand, int shelf) {
        this.location = Pair.of(stand, shelf);
    }

    public Set<AuthorDTO> getAuthors() {
        return authors;
    }

    public void addAuthor(AuthorDTO author) {
        authors.add(author);
    }
}
