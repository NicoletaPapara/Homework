package hotelmng.service;

import hotelmng.exception.EmployeeAgeValidationException;
import hotelmng.model.person.Employee;
import hotelmng.repository.EmployeeRepository;
import org.apache.log4j.spi.ErrorCode;

public class EmployeeService {

    private EmployeeRepository employeeRepository= new EmployeeRepository();

    public EmployeeService(){

    }

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void validateAndAdd(Employee employee) throws EmployeeAgeValidationException {

        if((employee.getAge() < employee.getMinAge()) || (employee.getAge() > employee.getMaxAge())) {
          throw new EmployeeAgeValidationException("Employee age should be between 18 and 60", ErrorCode.GENERIC_FAILURE)  ;
        }

        employeeRepository.add(employee);

    }
}
