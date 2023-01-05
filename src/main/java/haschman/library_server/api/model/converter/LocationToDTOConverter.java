package haschman.library_server.api.model.converter;

import haschman.library_server.api.model.LocationDTO;
import haschman.library_server.domain.Location;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LocationToDTOConverter implements Function<Location, LocationDTO> {
    @Override
    public LocationDTO apply(Location location) {
        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setId(location.getId());
        locationDTO.setStand(location.getStand());
        locationDTO.setShelf(location.getShelf());

        return locationDTO;
    }
}
