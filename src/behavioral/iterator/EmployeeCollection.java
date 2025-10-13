package behavioral.iterator;

import java.util.List;

public class EmployeeCollection implements Collection<Employee> {
    private List<Employee> employees;

    public EmployeeCollection(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Iterator<Employee> createIterator() {
        return new EmployeeIterator(employees);
    }
}
