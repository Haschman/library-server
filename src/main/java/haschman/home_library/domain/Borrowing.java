package haschman.home_library.domain;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Borrowing implements DomainEntity<Long> {
    private Long id;
    private Long id_book;
    private Long id_user;
    private SimpleDateFormat date;
    private SimpleDateFormat return_date;
    private Book book;
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
