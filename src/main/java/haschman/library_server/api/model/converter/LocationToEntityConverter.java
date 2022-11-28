package haschman.library_server.api.model.converter;

import haschman.library_server.api.model.LocationDTO;
import haschman.library_server.domain.Location;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LocationToEntityConverter implements Function<LocationDTO, Location> {
    @Override
    public Location apply(LocationDTO locationDTO) {
        return new Location(locationDTO.getId(), locationDTO.getStand(), locationDTO.getShelf());
    }
}
