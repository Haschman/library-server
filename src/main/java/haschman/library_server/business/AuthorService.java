package haschman.library_server.business;

import haschman.library_server.dao.AuthorRepository;
import haschman.library_server.domain.Author;
import haschman.library_server.domain.User;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AuthorService extends AbstractCrudService<User, Long> {
    public AuthorService(AuthorRepository authorRepository) {
        super(authorRepository);
    }

    /**
     * Find all authors of book with given ID.
     * @param bookId ID of a book.
     * @return collection of Authors of specified book.
     */
    public Collection<Author> getAllAuthorsOfBook(Long bookId) {
        return ((AuthorRepository) repository).findAllAuthorsOfBook(bookId);
    }

}
