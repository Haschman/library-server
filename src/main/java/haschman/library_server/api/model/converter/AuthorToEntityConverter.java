package haschman.library_server.api.model.converter;

import haschman.library_server.api.model.AuthorDTO;
import haschman.library_server.business.BookService;
import haschman.library_server.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AuthorToEntityConverter implements Function<AuthorDTO, Author> {
    @Override
    public Author apply(AuthorDTO authorDTO) {
        Author author = new Author();

        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());
        author.setNationality(authorDTO.getNationality());
        author.setCentury(authorDTO.getCentury());

        return author;

    }
}
