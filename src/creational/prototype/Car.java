package creational.prototype;

public class Car {
    private String color;
    private long price;

    public Car(long price, String color) {
        this.price = price;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Car(Car target) {
        if (target != null) {
            price = target.price;
            color = target.color;
        }
    }

    public Car clone() {
        return new Car(this);
    }

    public boolean isClone(Car target) {
        Car t =  target;
        if (color == t.color && price == t.price) {
            System.out.println(this + " and " + t + " are clones");
            return true;
        }
        System.out.println(this + " and " + target + " are NOT clones");
        return false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
