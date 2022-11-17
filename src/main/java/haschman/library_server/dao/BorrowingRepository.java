package haschman.library_server.dao;

import haschman.library_server.domain.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Long>, JpaRepository<Borrowing, Long> {
}
