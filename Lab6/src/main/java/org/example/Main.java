package org.example;

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog("Шарик", "Овчарка", 3);

        myDog.displayInfo();

        myDog.bark();

        myDog.setAge(5);

        System.out.println("Обновленный возраст " + myDog.getName() + ": " + myDog.getAge());
    }
}