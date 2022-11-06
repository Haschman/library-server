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
        if (repository.existsById(entity.getId()))
            throw new EntityStateException(entity, " already exists!");
        return repository.save(entity);
    }

    public Optional<E> readById(ID id) {
        return repository.findById(id);
    }

    public Collection<E> readAll() {
        return repository.findAll();
    }

    public E update(E entity) throws EntityStateException {
        if (repository.existsById(entity.getId()))
            return repository.save(entity);
        else
            throw new EntityStateException(entity, " cannot be found!");
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

}
