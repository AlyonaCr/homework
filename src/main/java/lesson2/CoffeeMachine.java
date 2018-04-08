package lesson2;

public class CoffeeMachine {

    private String brand = "De Longhi";
    private double weight = 9.7;

    @RandomInt
    private int power;
    private String typeOfCoffeeMachine = "Automatic";

    public CoffeeMachine() {
    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "brand='" + brand + '\'' +
                ", weight=" + weight +
                ", power=" + power +
                ", typeOfCoffeeMachine='" + typeOfCoffeeMachine + '\'' +
                '}';
    }
}