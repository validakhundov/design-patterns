package behavioral.iterator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee("Alice", 50000));
//        employees.add(new Employee("Bob", 60000));
//        employees.add(new Employee("Charlie", 70000));
//
//        EmployeeCollection employeeCollection = new EmployeeCollection(employees);
//        System.out.println(employeeCollection);
//
//        Iterator<Employee> iterator = employeeCollection.iterator();
////
//        double totalSalary = 0;
//
//        while (iterator.hasNext()) {
//            totalSalary += iterator.getCurrentAndGoNext().getSalary();
//        }
//
//        System.out.println("Total salary: " + totalSalary);
//
//
//        Set<Integer> set = new LinkedHashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(4);
//        set.add(5);
//
//
//        Iterator<Integer> iterator = set.iterator();
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        System.out.println(iterator.hasNext());


        var customer1 = new Customer("ABC", "Valid");
        var customer2 = new Customer("DFG", "Muslum");
        var customer3 = new Customer("HJK", "Ali");

        var customerCollection = new CustomerCollection();

        customerCollection.add(customer1)
                .add(customer2)
                .add(customer3);

        Iterator<Customer> customerIterator = customerCollection.iterator();
        while (customerIterator.hasNext()) {
            System.out.println(customerIterator.getCurrentAndGoNext());
        }
    }
}
