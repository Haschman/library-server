package haschman.library_server.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Entity
public class Borrowing implements DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private Long id_book; // Foreign Key
    private Long id_user; // Foreign Key
    @Column(nullable = false)
    private SimpleDateFormat date;
    @Column
    private SimpleDateFormat return_date;
    @ManyToOne
    private Book book;
    @ManyToOne
    private User user;

    public Borrowing() {
    }

    public Borrowing(Long id, SimpleDateFormat date, SimpleDateFormat return_date, Book book, User user) {
        this.id = id;
        this.date = Objects.requireNonNull(date);
        this.return_date = return_date;
        this.book = Objects.requireNonNull(book);
        this.id_book = book.getId();
        this.user = Objects.requireNonNull(user);
        this.id_user = user.getId();
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

    public SimpleDateFormat getReturn_date() {
        return return_date;
    }

    public void setReturn_date(SimpleDateFormat return_date) {
        this.return_date = return_date;
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
