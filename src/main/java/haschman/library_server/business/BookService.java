package haschman.library_server.business;

import haschman.library_server.dao.BookRepository;
import haschman.library_server.domain.Book;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Component
public class BookService extends AbstractCrudService<Book, Long> {
    private final BookRepository bookRepository;
    public BookService(BookRepository repository) {
        super(repository);
        bookRepository = repository;
    }

    public Collection<Book> findBooksByAuthor(Long authorId) {
        return bookRepository.findBooksByAuthor(authorId);
    }

    public Optional<Book> findBookByName(String name) {
        Collection<Book> books = repository.findAll();
        for (var book : books) {
            if (Objects.equals(book.getName(), name))
                return Optional.of(book);
        }
        return Optional.empty();
    }
}
