package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Car[] cars = {
                new Car("Toyota Camry", FuelType.PETROL),
                new Car("Tesla Model 3", FuelType.ELECTRIC),
                new Car("Volkswagen Golf", FuelType.DIESEL),
                new Car("Nissan Leaf", FuelType.ELECTRIC),
                new Car("Toyota Prius", FuelType.HYBRID)
        };

        System.out.println("Электромобили в списке:");
        for (Car car : cars) {
            if (car.getFuelType() == FuelType.ELECTRIC) {
                System.out.println(car.getModel());
            }
        }
    }
}
