package haschman.library_server.api;

import haschman.library_server.business.AbstractCrudService;
import haschman.library_server.business.EntityNotFoundException;
import haschman.library_server.business.EntityStateException;
import haschman.library_server.domain.DomainEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        if (bindingResult.hasErrors()) {
            System.out.println("ERROR JSON: " + bindingResult.getFieldError().getDefaultMessage());
            return new ResponseEntity<>(entityAsDTO, HttpStatus.BAD_REQUEST);
        }
        try {
            D DTO = toDTOConverter.apply(service.create(toEntityConverter.apply(entityAsDTO))); // This could throw
            return ResponseEntity.status(HttpStatus.CREATED).body(DTO);
        } catch (EntityNotFoundException e) {
            System.out.println("ERROR Something is missing: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (EntityStateException e) {
            System.out.println("ERROR " + e.getMessage());
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody D entityAsDTO, BindingResult bindingResult, @PathVariable ID id) {
        if (bindingResult.hasErrors()) {
            var field = bindingResult.getFieldError().getField();
            var message = bindingResult.getFieldError().getDefaultMessage();
            System.out.println("ERROR JSON: " + field + message);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ERROR: " + field + message);
        }
        try {
            service.update(toEntityConverter.apply(entityAsDTO));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR missing: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") ID id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            System.out.println("ERROR Something is missing: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
