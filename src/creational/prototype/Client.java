package creational.prototype;

public class Client {
    public static void main(String[] args) {
        Car c1 = new Car(30000, "red");

        Car c2 = c1.clone();
        c2.setColor("blue");

        System.out.println(c1.isClone(c2));


    }
}
