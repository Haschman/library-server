package haschman.library_server.api.model.converter;

import haschman.library_server.api.model.AuthorDTO;
import haschman.library_server.business.BookService;
import haschman.library_server.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AuthorToEntityConverter implements Function<AuthorDTO, Author> {

    private final BookService service;

    @Autowired
    public AuthorToEntityConverter(BookService service) {
        this.service = service;
    }

    @Override
    public Author apply(AuthorDTO authorDTO) {

        Author author = new Author();

        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());
        author.setCentury(authorDTO.getCentury());
        author.setNationality(authorDTO.getNationality());

        // Add book only if it exists in database. -> maybe could be somehow reported if the book cannot be found
        var books = authorDTO.getBooks();
        for (var book:books) {
            var maybeBook = service.findBookByName(book);
            if (maybeBook.isPresent())
                author.addBook(maybeBook.get());
            else
                System.out.println(book); // THIS IS NOT IDEAL
        }

        return author;

    }
}
