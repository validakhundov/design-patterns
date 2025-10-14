package behavioral.iterator;

import java.util.LinkedHashSet;
import java.util.Set;

public class CustomerCollection implements Collection<Customer> {
    private Set<Customer> customerSet;


    public CustomerCollection() {
        this.customerSet = new LinkedHashSet<>();
    }

    public CustomerCollection add(Customer customer) {
        this.customerSet.add(customer);
        return this;
    }

    @Override
    public String toString() {
        return "CustomerCollection{" +
                "customerSet=" + customerSet +
                '}';
    }

    @Override
    public Iterator<Customer> iterator() {
        return new CustomerIterator(this.customerSet);
    }
}
