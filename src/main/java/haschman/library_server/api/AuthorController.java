package haschman.library_server.api;

import haschman.library_server.api.model.AuthorDTO;
import haschman.library_server.api.model.converter.AuthorToDTOConverter;
import haschman.library_server.api.model.converter.AuthorToEntityConverter;
import haschman.library_server.business.AuthorService;
import haschman.library_server.domain.Author;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/authors")
public class AuthorController extends AbstractCrudController<Author, AuthorDTO, Long> {
    public AuthorController(AuthorService authorService, AuthorToDTOConverter authorToDTOConverter, AuthorToEntityConverter authorToEntityConverter) {
        super(authorService, authorToDTOConverter, authorToEntityConverter);
    }

    public Collection<AuthorDTO> readAll() {
        return super.readAll();
    }
}
