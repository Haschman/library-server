package haschman.library_server.api.model.converter;

import haschman.library_server.api.model.BookDTO;
import haschman.library_server.domain.Author;
import haschman.library_server.domain.Book;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

@Component
public class BookToDTOConverter implements Function<Book, BookDTO> {
    @Override
    public BookDTO apply(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setLanguage(book.getLanguage());
        bookDTO.setISBN(book.getISBN());
        bookDTO.setPublication_date(book.getPublication_date());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setLocation(book.getLocation());
        bookDTO.setAuthors(book.getAuthor());

        return bookDTO;
    }
}
