package hotelmng.exception;

public class RoomValidationException extends Throwable {
    private final int errorCode;
    public RoomValidationException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
