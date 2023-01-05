package haschman.library_server.business;

import haschman.library_server.dao.AuthorRepository;
import haschman.library_server.domain.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorService extends AbstractCrudService<Author, Long> {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        super(authorRepository);
        this.authorRepository = authorRepository;
    }
    public Integer countAllAuthors() {
        return authorRepository.countAllAuthors();
    }
}
