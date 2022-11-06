package haschman.library_server.dao;

import haschman.library_server.domain.User;

public interface AuthorRepository extends CrudRepository<User, Long> {
}
