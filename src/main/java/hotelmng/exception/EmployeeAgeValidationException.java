package hotelmng.exception;

import org.apache.log4j.spi.ErrorCode;

public class EmployeeAgeValidationException extends Exception {

    private final int code;

    public EmployeeAgeValidationException(String message, int code){
        super(message);
        this.code = code;
    }
}
