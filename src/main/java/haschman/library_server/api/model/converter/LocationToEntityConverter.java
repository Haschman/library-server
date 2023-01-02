package haschman.library_server.api.model.converter;

import haschman.library_server.api.model.LocationDTO;
import haschman.library_server.domain.Location;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LocationToEntityConverter implements Function<LocationDTO, Location> {
    @Override
    public Location apply(LocationDTO locationDTO) {
        Location location = new Location();

        location.setId(locationDTO.getId());
        location.setStand(locationDTO.getStand());
        location.setShelf(locationDTO.getShelf());

        return location;
    }
}
