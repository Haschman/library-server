package haschman.library_server.api.model;

import org.springframework.data.util.Pair;

import java.text.SimpleDateFormat;
import java.util.Set;

public class BookDTO {
    Long id;
    String name;
    String language;
    Long ISBN;
    SimpleDateFormat publication_date;
    String category;
    String genre;
    // first -> stand; second -> shelf
    Pair<Integer, Integer> location;
    Set<Pair<String, String>> authors;

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

    public Pair<Integer, Integer> getLocation() {
        return location;
    }

    /**
     * @param stand is first
     * @param shelf is second
     */
    public void setLocation(Integer stand, Integer shelf) {
        this.location = Pair.of(stand, shelf);
    }

    public Set<Pair<String, String>> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Pair<String, String>> authors) {
        this.authors = authors;
    }
}
