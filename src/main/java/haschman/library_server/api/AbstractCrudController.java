package haschman.library_server.api;

import haschman.library_server.business.AbstractCrudService;
import haschman.library_server.business.EntityStateException;
import haschman.library_server.domain.DomainEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.function.Function;

public class AbstractCrudController<E extends DomainEntity<ID>, D, ID> {
    protected AbstractCrudService<E, ID> service;
    protected Function<E, D> toDTOConverter;
    protected Function<D, E> toEntityConverter;

    public AbstractCrudController(AbstractCrudService<E, ID> service, Function<E, D> toDTOConverter, Function<D, E> toEntityConverter) {
        this.service = service;
        this.toDTOConverter = toDTOConverter;
        this.toEntityConverter = toEntityConverter;
    }

    @PostMapping
    public ResponseEntity<D> create(@Valid @RequestBody D entityAsDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(entityAsDTO, HttpStatus.BAD_REQUEST);
        try {
            D DTO = toDTOConverter.apply(service.create(toEntityConverter.apply(entityAsDTO))); // This could throw
            return ResponseEntity.status(HttpStatus.CREATED).body(DTO);
        } catch (EntityStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    public Collection<D> readAll() {
        return service.readAll().stream().map(toDTOConverter).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> readOne(@PathVariable ID id) {
        var response = service.readById(id);
        if (response.isPresent())
            return ResponseEntity.ok(toDTOConverter.apply(response.get()));
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public void update(@RequestBody D entityAsDTO, @PathVariable("id") ID id) {
        service.update(toEntityConverter.apply(entityAsDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") ID id) {
        service.deleteById(id);
    }
}
