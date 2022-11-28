package haschman.library_server.api.model.converter;

import haschman.library_server.api.model.BookDTO;
import haschman.library_server.domain.Author;
import haschman.library_server.domain.Book;
import haschman.library_server.domain.Location;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

@Component
public class BookToEntityConverter implements Function<BookDTO, Book> {
    @Override
    public Book apply(BookDTO bookDTO) {
        return new Book(bookDTO.getId(), bookDTO.getName(), bookDTO.getLanguage(), bookDTO.getISBN(), bookDTO.getPublication_date(), bookDTO.getCategory(), bookDTO.getGenre(), bookDTO.getAuthors(), bookDTO.getLocation());
    }
}

