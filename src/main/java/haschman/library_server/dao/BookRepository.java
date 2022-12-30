package haschman.library_server.dao;

import haschman.library_server.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>, JpaRepository<Book, Long> {
    @Query("select b from Book b join b.authors a where a.id = :authorID")
    Collection<Book> findBooksByAuthor(@Param("authorID") Long authorID);
}
