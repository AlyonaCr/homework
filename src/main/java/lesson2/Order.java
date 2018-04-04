package lesson2;

public class Order {

    @RandomInt
    private int numberOfOrder;
    private int numberOfOrderedItem = 1;
    private String nameOfCustomer = "Vasya";
    String phoneNumber = "79110000000";

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "numberOfOrder=" + numberOfOrder +
                ", numberOfOrderedItem=" + numberOfOrderedItem +
                ", nameOfCustomer='" + nameOfCustomer + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
