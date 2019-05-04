package hotelmng.service;

import hotelmng.model.person.Employee;
import hotelmng.repository.EmployeeRepository;

public class EmployeeService {

    private EmployeeRepository employeeRepository= new EmployeeRepository();

    public EmployeeService(){

    }

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void validateAndAdd(Employee employee) throws EmployeeAgeValidationException {

        if((employee.getAge() < employee.getMinAge()) || (employee.getAge() > employee.getMaxAge())) {
          throw new EmployeeAgeValidationException("Employee age should be between 18 and 60")  ;
        }

        employeeRepository.addEmployee(employee);

    }
}
