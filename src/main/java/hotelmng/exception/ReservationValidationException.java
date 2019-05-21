package hotelmng.exception;

public class ReservationValidationException extends Throwable {
    private final int errorCode;
    public ReservationValidationException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
