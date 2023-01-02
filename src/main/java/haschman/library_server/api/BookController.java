package haschman.library_server.api;

import haschman.library_server.api.model.BookDTO;
import haschman.library_server.api.model.converter.BookToDTOConverter;
import haschman.library_server.api.model.converter.BookToEntityConverter;
import haschman.library_server.business.BookService;
import haschman.library_server.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/author")
    public Collection<BookDTO> findAllByAuthor(@RequestParam Long authorID) {
        return ((BookService)service).findBooksByAuthor(authorID).stream().map(toDTOConverter).toList();
    }

    @GetMapping("/location")
    public Collection<BookDTO> findAllFromLocation(@RequestParam Long locationID) {
        return ((BookService)service).findBooksByLocation(locationID).stream().map(toDTOConverter).toList();
    }
}
