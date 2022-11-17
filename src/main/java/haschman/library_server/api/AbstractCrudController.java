package haschman.library_server.api;

import haschman.library_server.business.AbstractCrudService;
import haschman.library_server.domain.DomainEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.function.Function;

public class AbstractCrudController<E extends DomainEntity<ID>, D, ID> {
    protected AbstractCrudService<E, ID> service;
    protected Function<E, D> toDtoConverter;
    protected Function<D, E> toEntityConverter;

    public AbstractCrudController(AbstractCrudService<E, ID> service, Function<E, D> toDtoConverter, Function<D, E> toEntityConverter) {
        this.service = service;
        this.toDtoConverter = toDtoConverter;
        this.toEntityConverter = toEntityConverter;
    }

    @PostMapping
    public D create(@RequestBody D entityAsDTO) {
        return toDtoConverter.apply(service.create(toEntityConverter.apply(entityAsDTO)));
    }

    @GetMapping
    public Collection<D> readAll() {
        return service.readAll().stream().map(toDtoConverter).toList();
    }

    @PutMapping("/{id}")
    public void update(@RequestBody D entityAsDTO, @PathVariable("id") ID id) {
        service.update(toEntityConverter.apply(entityAsDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") ID id) {
        service.deleteById(id);
    }
}
