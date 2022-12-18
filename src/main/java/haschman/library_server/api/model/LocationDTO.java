package haschman.library_server.api.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class LocationDTO {
    @Min(1)
    @Max(100)
    private int stand;
    @Min(1)
    @Max(100)
    private int shelf;

    public int getStand() {
        return stand;
    }

    public void setStand(int stand) {
        this.stand = stand;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }
}
