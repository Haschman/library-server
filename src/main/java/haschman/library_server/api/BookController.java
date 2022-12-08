package haschman.library_server.api;

import haschman.library_server.api.model.BookDTO;
import haschman.library_server.api.model.converter.BookToDTOConverter;
import haschman.library_server.api.model.converter.BookToEntityConverter;
import haschman.library_server.business.BookService;
import haschman.library_server.domain.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BookController extends AbstractCrudController<Book, BookDTO, Long> {
    public BookController(BookService service, BookToDTOConverter bookToDTOConverter, BookToEntityConverter bookToEntityConverter) {
        super(service, bookToDTOConverter, bookToEntityConverter);
    }

    public Collection<BookDTO> readAll() {
        return super.readAll();
    }
}