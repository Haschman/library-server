package haschman.library_server.api;

import haschman.library_server.api.model.BookDTO;
import haschman.library_server.api.model.converter.BookToDTOConverter;
import haschman.library_server.api.model.converter.BookToEntityConverter;
import haschman.library_server.business.BookService;
import haschman.library_server.domain.Book;
import org.springframework.web.bind.annotation.*;

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
        return ((BookService)service).findBooksFromLocation(locationID).stream().map(toDTOConverter).toList();
    }

    @GetMapping("/count")
    public Integer countAllBooks() {
        return ((BookService)service).countAllBooks();
    }

    @DeleteMapping("/author")
    public void deleteAllBooksByAuthor(@RequestParam Long authorID) {
        ((BookService)service).deleteAllBooksByAuthor(authorID);
    }

    @DeleteMapping("/location")
    public void deleteAllBooksFromLocation(@RequestParam Long locationID) {
        ((BookService)service).deleteAllBooksFromLocation(locationID);
    }
}
