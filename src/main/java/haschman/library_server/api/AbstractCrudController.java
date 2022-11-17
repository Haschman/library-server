package haschman.library_server.api;

import haschman.library_server.business.AbstractCrudService;
import haschman.library_server.domain.DomainEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class AbstractCrudController<E extends DomainEntity<ID>, D, ID> {
    protected AbstractCrudService<E, ID> service;


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") ID id) {
        service.deleteById(id);
    }
}
