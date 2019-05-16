package hotelmng.exception;

import org.apache.log4j.spi.ErrorCode;

public class EmployeeAgeValidationException extends Exception {

    private ErrorCode code;
    public EmployeeAgeValidationException(String message) {
        super(message);
    }

    public EmployeeAgeValidationException(String message, Throwable cause, ErrorCode code){
        super(message,cause);
        this.code = code;
    }
}
