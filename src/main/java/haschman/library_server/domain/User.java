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

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
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

}
