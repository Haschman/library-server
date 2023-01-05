package haschman.library_server.api.model.converter;

import haschman.library_server.api.model.AuthorDTO;
import haschman.library_server.api.model.BookDTO;
import haschman.library_server.domain.Author;
import haschman.library_server.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
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
        bookDTO.setPublicationYear(book.getPublicationYear());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setLocation(book.getLocation().getId());

        Collection<Author> allAuthors = book.getAuthor();
        for (var author : allAuthors)
            bookDTO.addAuthor(author.getId());

        return bookDTO;
    }
}
