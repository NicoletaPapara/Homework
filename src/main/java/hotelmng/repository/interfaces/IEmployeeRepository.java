package hotelmng.repository.interfaces;

import hotelmng.model.person.Employee;

import java.util.Set;

public interface IEmployeeRepository {

    public void addEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public Set<Employee> listEmployee();
}
