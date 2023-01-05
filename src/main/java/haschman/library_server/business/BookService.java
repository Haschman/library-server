package haschman.library_server.business;

import haschman.library_server.dao.BookRepository;
import haschman.library_server.domain.Book;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;

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

    public Collection<Book> findBooksFromLocation(Long locationId) {
        return bookRepository.findBooksFromLocation(locationId);
    }

    public Integer countAllBooks() {
        return bookRepository.countAllBooks();
    }

    @Transactional
    public void deleteAllBooksByAuthor(Long authorID) {
        Collection<Book> booksByAuthor = findBooksByAuthor(authorID);
        for (Book book : booksByAuthor) {
            deleteById(book.getId());
        }
    }

    @Transactional
    public void deleteAllBooksFromLocation(Long authorID) {
        Collection<Book> booksFromLocation = findBooksFromLocation(authorID);
        for (Book book : booksFromLocation) {
            deleteById(book.getId());
        }
    }
}
