package haschman.library_server.api.model.converter;

import haschman.library_server.api.model.AuthorDTO;
import haschman.library_server.domain.Author;

import java.util.function.Function;

public class AuthorToDTOConverter implements Function<Author, AuthorDTO> {
    public AuthorDTO apply(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setSurname(author.getSurname());
        authorDTO.setNationality(author.getNationality());
        authorDTO.setCentury(author.getCentury());
        return authorDTO;
    }
}
