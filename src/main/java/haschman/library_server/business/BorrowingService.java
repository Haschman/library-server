package haschman.library_server.business;

import haschman.library_server.dao.BorrowingRepository;
import haschman.library_server.domain.Borrowing;
import org.springframework.stereotype.Component;

@Component
public class BorrowingService extends AbstractCrudService<Borrowing, Long> {
    public BorrowingService(BorrowingRepository repository) {
        super(repository);
    }
}
