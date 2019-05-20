package hotelmng.repository.interfaces;

import hotelmng.model.person.Employee;

import java.util.List;

public interface IEmployeeRepository {

    public void addEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public List<Employee> listEmployee();
}
