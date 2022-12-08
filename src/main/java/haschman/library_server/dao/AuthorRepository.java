package haschman.library_server.dao;

import haschman.library_server.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>, JpaRepository<Author, Long> {
}
