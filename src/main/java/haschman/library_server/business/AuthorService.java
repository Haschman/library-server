package haschman.library_server.business;

import haschman.library_server.api.model.AuthorDTO;
import haschman.library_server.dao.AuthorRepository;
import haschman.library_server.domain.Author;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class AuthorService extends AbstractCrudService<Author, Long> {
    public AuthorService(AuthorRepository authorRepository) {
        super(authorRepository);
    }

    public Optional<Author> findAuthor(AuthorDTO authorDTO) {
        Author intruder = new Author(authorDTO.getName(), authorDTO.getSurname(), authorDTO.getNationality(), authorDTO.getCentury());
        Collection<Author> authors = repository.findAll();
        for (var member : authors)
            if (member.equals(intruder))
                return Optional.of(intruder);
        return Optional.empty();
    }
}
