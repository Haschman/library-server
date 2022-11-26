package haschman.library_server.business;

import haschman.library_server.dao.BookRepository;
import haschman.library_server.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class BookService extends AbstractCrudService<Book, Long> {
    public BookService(BookRepository repository) {
        super(repository);
    }
}
