package hotelmng.exception;

public class EmployeeAgeValidationException extends Exception {

    private final int code;

    public EmployeeAgeValidationException(String message, int code) {
        super(message);
        this.code = code;
    }
}
