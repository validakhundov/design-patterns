package behavioral.iterator;

public class Customer {
    private String cif;
    private String name;


    public Customer(String cif, String name) {
        this.cif = cif;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cif='" + cif + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
