package hotelmng.repository;

import hotelmng.model.person.Employee;
import hotelmng.repository.interfaces.IEmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepository implements IEmployeeRepository {
    Set<Employee> employeeSet = new HashSet<Employee>();

    public void addEmployee(Employee employee) {
        employeeSet.add(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeSet.remove(employee);
    }

    public Set<Employee> listEmployee() {
        return employeeSet;
    }
}
