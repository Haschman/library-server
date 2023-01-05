package haschman.library_server.business;

import haschman.library_server.dao.CrudRepository;
import haschman.library_server.domain.DomainEntity;

import java.util.Collection;
import java.util.Optional;

/**
 * Abstract class for Create, Read, Update and Delete.
 * @param <E> is type of entity
 * @param <ID> is type of ID
 */
public abstract class AbstractCrudService<E extends DomainEntity<ID>, ID> {
    protected final CrudRepository<E, ID> repository;

    protected AbstractCrudService(CrudRepository<E, ID> repository) {
        this.repository = repository;
    }

    public E create(E entity) throws EntityStateException {
        Collection<E> all = repository.findAll();
        for (var one : all)
            if (one.equals(entity))
                throw new EntityStateException(entity.getClass().getSimpleName(), " already exists!");
        return repository.save(entity);
    }

    public Optional<E> readById(ID id) {
        return repository.findById(id);
    }

    public Collection<E> readAll() {
        return repository.findAll();
    }

    /**
     * @throws EntityNotFoundException if ID is not found
     */
    public E update(E entity) {
        if (repository.existsById(entity.getId())) { // Find Entity to update
            Collection<E> all = repository.findAll();
            for (var one : all)
                if (one.equals(entity) && one.getId() != entity.getId())
                    throw new EntityStateException(entity.getClass().getSimpleName(), " already exists!");
            return repository.save(entity);
        }
        throw new EntityNotFoundException(entity.toString());
    }

    /**
     * @throws EntityNotFoundException if ID is not found
     */
    public void deleteById(ID id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new EntityNotFoundException("Entity with ID: " + id);
    }
}
