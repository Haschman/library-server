package haschman.home_library.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Vector;

public class User implements DomainEntity<Long> {
    private Long id;
    private String name;
    private Vector<Borrowing> borrowings;

    public User() {
    }

    public User(Long id, String name, Vector<Borrowing> borrowings) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.borrowings = borrowings;
    }

    @Override
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

    public Collection<Borrowing> getBorrowings() {
        return Collections.unmodifiableCollection(borrowings);
    }

    public void addBorrowing(Borrowing borrowing) {
        borrowings.add(Objects.requireNonNull(borrowing));
    }
}
