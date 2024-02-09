package francescobuonocore.u5d5.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Item with id " + id + "has not been found");
    }
}
