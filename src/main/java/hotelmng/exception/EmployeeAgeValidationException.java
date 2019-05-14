package hotelmng.service;

import org.apache.log4j.spi.ErrorCode;

public class EmployeeAgeValidationException extends Exception {
    public EmployeeAgeValidationException(String message) {
        super(message);
    }
}
