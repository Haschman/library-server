package haschman.library_server.dao;

import java.util.Collection;
import java.util.Optional;

public interface CrudRepository<T, ID> {

    /**
     * Saves given entity and returns it (it could be used afterwards).
     * @param entity cannot be {@literal null}.
     * @return saved entity.
     * @throws IllegalArgumentException if {@literal entity} is null.
     */
    T save(T entity);

    /**
     * Returns the entity with given ID.
     * @param id cannot be {@literal null}.
     * @return the entity with the given id if found.
     * @throws IllegalArgumentException if {@literal id} is null.
     */
    Optional<T> findById(ID id);

    /**
     * Checks if there is entity with given ID.
     * @param id cannot be {@literal null}.
     * @throws IllegalArgumentException if {@literal id} is null.
     * @return {@literal true} if entity exists; {@literal false} otherwise.
     */
    boolean existsById(ID id);

    /**
     * Find all entities.
     * @return collection of all entities.
     */
    Collection<T> findAll();

    /**
     * Deletes the entity with ID from param.
     * @param id cannot be {@literal null}.
     * @throws IllegalArgumentException if {@literal id} is null.
     */
    void deleteById(ID id);
}
