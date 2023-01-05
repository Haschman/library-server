package haschman.library_server.business;

import haschman.library_server.dao.UserRepository;
import haschman.library_server.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserService extends AbstractCrudService<User, Long> {
    public UserService(UserRepository repository) {
        super(repository);
    }
}
