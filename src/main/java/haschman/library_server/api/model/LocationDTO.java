package haschman.library_server.api.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class LocationDTO {
    private Long id;
    @Min(1)
    @Max(100)
    @NotNull
    private int stand;
    @Min(1)
    @Max(100)
    @NotNull
    private int shelf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
