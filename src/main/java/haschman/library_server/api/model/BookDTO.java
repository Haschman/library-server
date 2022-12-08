package haschman.library_server.api.model;

import org.springframework.data.util.Pair;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BookDTO {
    String name;
    String language;
    Long ISBN;
    Date publication_date;
    String category;
    String genre;
    Pair<Integer, Integer> location;
    Set<AuthorDTO> authors = new HashSet<>();

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
