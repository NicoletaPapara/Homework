package hotelmng.repository;

import hotelmng.repository.interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository<T> implements IRepository<T> {
    private List<T> employees = new ArrayList<>();


    @Override
    public void add(T o) {
        employees.add(o);
    }

    @Override
    public void delete(T o) {
        employees.remove(o);
    }

    @Override
    public List<T> list() {
        return employees;
    }
}
