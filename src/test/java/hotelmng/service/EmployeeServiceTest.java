package hotelmng.service;

import hotelmng.exception.EmployeeAgeValidationException;
import hotelmng.model.person.Employee;
import hotelmng.model.person.Receptionist;
import hotelmng.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setup() {
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void shouldThrowExceptionWhenAgeBelowLimitTest() throws EmployeeAgeValidationException {
        //GIVEN
        Employee employee = new Receptionist(1234, "1181111111111", "Bibi");

        //WHEN & THEN
        Assertions.assertThrows(EmployeeAgeValidationException.class, () -> employeeService.validateAndAdd(employee));

    }


}