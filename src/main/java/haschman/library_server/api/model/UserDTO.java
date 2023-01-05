package haschman.library_server.api.model;

import org.springframework.data.util.Pair;

import java.text.SimpleDateFormat;
import java.util.Set;

public class UserDTO {
    private Long id;
    private String name;
    // Pair of Book name and Borrowing date
    private Set<Pair<String, SimpleDateFormat>> borrowings;

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

    public Set<Pair<String, SimpleDateFormat>> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(Set<Pair<String, SimpleDateFormat>> borrowings) {
        this.borrowings = borrowings;
    }
}
