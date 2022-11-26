package haschman.library_server.business;

import haschman.library_server.dao.LocationRepository;
import haschman.library_server.domain.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationService extends AbstractCrudService<Location, Long> {
    public LocationService(LocationRepository repository) {
        super(repository);
    }
}
