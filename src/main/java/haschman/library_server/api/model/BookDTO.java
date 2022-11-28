package haschman.library_server.api.model;

import haschman.library_server.domain.Author;
import haschman.library_server.domain.Location;

import java.util.Date;
import java.util.Set;

public class BookDTO {
    Long id;
    String name;
    String language;
    Long ISBN;
    Date publication_date;
    String category;
    String genre;
    Location location;
    Set<Author> authors;

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

    public void setPublication_date(Date publication_dateS) {
        // format yyyy-MM-dd
        this.publication_date = publication_dateS;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
