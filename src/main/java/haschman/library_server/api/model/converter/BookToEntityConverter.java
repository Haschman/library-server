package haschman.library_server.api.model.converter;

import haschman.library_server.api.model.AuthorDTO;
import haschman.library_server.api.model.BookDTO;
import haschman.library_server.business.AbstractCrudService;
import haschman.library_server.business.AuthorService;
import haschman.library_server.business.EntityStateException;
import haschman.library_server.business.LocationService;
import haschman.library_server.domain.Author;
import haschman.library_server.domain.Book;
import haschman.library_server.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

@Component
public class BookToEntityConverter implements Function<BookDTO, Book> {
    private final LocationService locationService;
    private final AuthorService authorService;

    @Autowired
    public BookToEntityConverter(LocationService service, AuthorService authorService) {
        this.locationService = service;
        this.authorService = authorService;
    }

    @Override
    public Book apply(BookDTO bookDTO) throws EntityStateException {
        Book book = new Book();

        book.setName(bookDTO.getName());
        book.setLanguage(bookDTO.getLanguage());
        book.setISBN(bookDTO.getISBN());
        book.setPublication_date(bookDTO.getPublication_date());
        book.setCategory(bookDTO.getCategory());
        book.setGenre(bookDTO.getGenre());

        Optional<Location> location = locationService.findLocation(bookDTO.getLocation().getFirst(), bookDTO.getLocation().getSecond());
        if (location.isPresent())
            book.setLocation(location.get());
        else
            throw new EntityStateException("Location does not exist");

        Collection<AuthorDTO> allAuthorsDTO = bookDTO.getAuthors();
        for (var authorDTO : allAuthorsDTO) {
            Optional<Author> author = authorService.findAuthor(authorDTO);
            if (author.isPresent())
                book.addAuthor(author.get());
            else
                throw new EntityStateException("Author does not exist: " + authorDTO.getSurname());
        }

        return book;
    }
}

