package haschman.library_server.business;

import haschman.library_server.dao.AuthorRepository;
import haschman.library_server.domain.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorService extends AbstractCrudService<Author, Long> {
    public AuthorService(AuthorRepository authorRepository) {
        super(authorRepository);
    }
}
