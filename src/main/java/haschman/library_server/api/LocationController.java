package haschman.library_server.api;

import haschman.library_server.api.model.LocationDTO;
import haschman.library_server.api.model.converter.LocationToDTOConverter;
import haschman.library_server.api.model.converter.LocationToEntityConverter;
import haschman.library_server.business.LocationService;
import haschman.library_server.domain.Location;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/locations")
public class LocationController extends AbstractCrudController<Location, LocationDTO, Long> {
    public LocationController(LocationService locationService, LocationToDTOConverter locationToDTOConverter, LocationToEntityConverter locationToEntityConverter) {
        super(locationService, locationToDTOConverter, locationToEntityConverter);
    }

    public Collection<LocationDTO> readAll() {
        return super.readAll();
    }
}
