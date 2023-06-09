package haschman.library_server.dao;

import haschman.library_server.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>, JpaRepository<Location, Long> {
}
