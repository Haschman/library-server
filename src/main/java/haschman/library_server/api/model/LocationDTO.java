package haschman.library_server.api.model;

public class LocationDTO {
    //Long id;
    int stand;
    int shelf;

    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
     */

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
