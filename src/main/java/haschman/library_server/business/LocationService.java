package haschman.library_server.business;

import haschman.library_server.dao.LocationRepository;
import haschman.library_server.domain.Location;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class LocationService extends AbstractCrudService<Location, Long> {
    public LocationService(LocationRepository repository) {
        super(repository);
    }

    public Optional<Location> findLocation(int stand, int shelf) {
        Location intruder = new Location(stand, shelf);
        Collection<Location> locations = repository.findAll();
        for (var member : locations)
            if (intruder.equals(member))
                return Optional.of(intruder);
        return Optional.empty();
    }

    @Override
    public Location create(Location location) throws EntityStateException {
        if (findLocation(location.getStand(), location.getShelf()).isPresent())
            throw new EntityStateException(location, " already exists");
        return repository.save(location);
    }
}
