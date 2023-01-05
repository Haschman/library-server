package haschman.library_server.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Entity
public class Borrowing implements DomainEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private SimpleDateFormat date;
    @Column(name = "return_date")
    private SimpleDateFormat returnDate;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Borrowing() {
    }

    public Borrowing(Long id, SimpleDateFormat date, SimpleDateFormat returnDate, Book book, User user) {
        this.id = id;
        this.date = Objects.requireNonNull(date);
        this.returnDate = returnDate;
        this.book = Objects.requireNonNull(book);
        this.user = Objects.requireNonNull(user);
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public SimpleDateFormat getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(SimpleDateFormat return_date) {
        this.returnDate = return_date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
