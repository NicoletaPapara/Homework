package hotelmng.exception;

public class RemoveHotelValidationException extends RuntimeException {
    private final int code;

    public RemoveHotelValidationException(String message, int code) {
        super(message);
        this.code = code;
    }
}
