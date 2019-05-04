package hotelmng.service;

import hotelmng.model.person.Employee;
import hotelmng.model.person.Receptionist;
import hotelmng.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setup(){
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test(expected = EmployeeAgeValidationException.class)
    public void shouldThrowExceptionWhenAgeBelowLimitTest() throws EmployeeAgeValidationException {
        //GIVEN
        Employee employee = new Receptionist(1234, "1181111111111", "Bibi");

        //WHEN
        employeeService.validateAndAdd(employee);

    }
}