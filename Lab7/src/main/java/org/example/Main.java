package org.example;

public class Main {
    public static void main(String[] args) {
        Airplane plane1 = new Airplane("Boeing 737", 150, 5000);
        Airplane plane2 = new Airplane("Airbus A320", 180, 6000);
        Airplane plane3 = new Airplane("Embraer E190", 100, 4500);

        System.out.println("Самолет 1: " + plane1.getModel() + ", Вместимость: " + plane1.getCapacity());
        System.out.println("Самолет 2: " + plane2.getModel() + ", Вместимость: " + plane2.getCapacity());
        System.out.println("Самолет 3: " + plane3.getModel() + ", Вместимость: " + plane3.getCapacity());

        System.out.println("------------------------------------");

        System.out.println("Всего самолетов создано: " + Airplane.getTotalPlanes());
        System.out.println(plane1 == plane2);
        double average = Airplane.getAverageCapacity();
        System.out.printf("Средняя вместимость всех самолетов: %.2f чел.\n", average);
    }
}