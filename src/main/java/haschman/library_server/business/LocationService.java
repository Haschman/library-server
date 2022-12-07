package haschman.library_server.business;

import haschman.library_server.dao.LocationRepository;
import haschman.library_server.domain.Location;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class LocationService extends AbstractCrudService<Location, Long> {
    public LocationService(LocationRepository repository) {
        super(repository);
    }

    @Override
    public Location create(Location location) throws EntityStateException {
        Collection<Location> locations = repository.findAll();
        for (var loc : locations) {
            if (location.equals(loc))
                throw new EntityStateException(location, " already exists");
        }
        return repository.save(location);
    }
}
