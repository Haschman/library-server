package haschman.library_server.api.model;

import org.springframework.data.util.Pair;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.util.Set;

public class BookDTO {
    Long id;
    String name;
    String language;
    Long ISBN;
    SimpleDriverDataSource publication_date;
    String category;
    String genre;
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

    public SimpleDriverDataSource getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(SimpleDriverDataSource publication_date) {
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

    public void setLocation(Pair<Integer, Integer> location) {
        this.location = location;
    }

    public Set<Pair<String, String>> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Pair<String, String>> authors) {
        this.authors = authors;
    }
}
