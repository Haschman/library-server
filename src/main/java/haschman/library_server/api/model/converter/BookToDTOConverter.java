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
    private final Function<Author, AuthorDTO> authorToDto;

    @Autowired
    public BookToDTOConverter(Function<Author, AuthorDTO> authorToDto) {
        this.authorToDto = authorToDto;
    }

    @Override
    public BookDTO apply(Book book) {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setLanguage(book.getLanguage());
        bookDTO.setISBN(book.getISBN());
        bookDTO.setPublication_year(book.getPublication_year());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setShelf(book.getLocation().getShelf());
        bookDTO.setStand(book.getLocation().getStand());

        Collection<Author> allAuthorsEntity = book.getAuthor();
        for (var authorEntity : allAuthorsEntity)
            bookDTO.addAuthor(authorToDto.apply(authorEntity));

        return bookDTO;
    }
}
