package behavioral.iterator;

import java.util.LinkedHashSet;
import java.util.Set;

public class CustomerIterator implements Iterator<Customer> {

    Set<Customer> set = new LinkedHashSet<>();
    java.util.Iterator<Customer> iteratorOfSet;

    public CustomerIterator(Set<Customer> set) {
        this.set = set;
        iteratorOfSet = set.iterator();
    }

    @Override
    public boolean hasNext() {
        return iteratorOfSet.hasNext();
    }

    @Override
    public Customer getCurrentAndGoNext() {
        return iteratorOfSet.next();
    }
}
