package haschman.library_server.business;

public class EntityStateException extends RuntimeException {
    public EntityStateException(){
    }

    public <E> EntityStateException(E entity) {
        super("Illegal state of entity " + entity);
    }

    public EntityStateException(String s) {
        super(s);
    }
}
