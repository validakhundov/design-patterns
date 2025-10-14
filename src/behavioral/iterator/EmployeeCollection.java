package behavioral.iterator;

import java.util.List;

public class EmployeeCollection implements Collection<Employee> {
    private List<Employee> employees;

    public EmployeeCollection(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Iterator<Employee> iterator() {
        return new EmployeeIterator(employees);
    }


    @Override
    public String toString() {
        return "EmployeeCollection{" +
                "employees=" + employees +
                '}';
    }
}
