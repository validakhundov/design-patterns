package behavioral.iterator;

import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeIterator implements Iterator<Employee> {
    private int currentIndex = 0;
    private List<Employee> employees;

    public EmployeeIterator(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < employees.size();
    }

    @Override
    public Employee getCurrentAndGoNext() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Employee currEmployee = employees.get(currentIndex);
        currentIndex++;
        return currEmployee;
    }
}
