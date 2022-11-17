package haschman.library_server.dao;

import haschman.library_server.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>, JpaRepository<Book, Long> {
}
