package haschman.library_server.api.model.converter;

import haschman.library_server.api.AuthorController;
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
    private final Function<Author, AuthorDTO> authorToDto;

    @Autowired
    public BookToDTOConverter(Function<Author, AuthorDTO> authorToDto) {
        this.authorToDto = authorToDto;
    }

    @Override
    public BookDTO apply(Book book) {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setName(book.getName());
        bookDTO.setLanguage(book.getLanguage());
        bookDTO.setISBN(book.getISBN());
        bookDTO.setPublication_date(book.getPublication_date());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setLocation(book.getLocation().getStand(), book.getLocation().getShelf());

        Collection<Author> allAuthorsEntity = book.getAuthor();
        for (var authorEntity : allAuthorsEntity)
            bookDTO.addAuthor(authorToDto.apply(authorEntity));

        return bookDTO;
    }
}
