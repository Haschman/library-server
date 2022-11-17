package haschman.library_server.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "userrr")
public class User implements DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToMany
    private Set<Borrowing> borrowings = new HashSet<>();

    public User() {
    }

    public User(Long id, String name, Set<Borrowing> borrowings) {
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