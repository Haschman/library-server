package haschman.library_server.business;

public class EntityNotFoundException extends EntityStateException {
    public EntityNotFoundException(String s) {
        super(s);
    }
}
