package haschman.library_server.api.model.converter;

import haschman.library_server.api.model.AuthorDTO;
import haschman.library_server.domain.Author;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AuthorToEntityConverter implements Function<AuthorDTO, Author> {
    @Override
    public Author apply(AuthorDTO authorDTO) {
        return new Author(authorDTO.getId(), authorDTO.getName(), authorDTO.getSurname(), authorDTO.getNationality(), authorDTO.getCentury());
    }
}
