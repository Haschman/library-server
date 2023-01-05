package haschman.library_server.api.model;

import java.text.SimpleDateFormat;

public class BorrowingDTO {
    private Long id;
    private String bookName;
    private String userName;
    private SimpleDateFormat date;
    private SimpleDateFormat returnDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public void setReturnDate(SimpleDateFormat returnDate) {
        this.returnDate = returnDate;
    }
}
