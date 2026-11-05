package org.example;

public class Person {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public int getAge() {
        int currentYear = 2026; // Текущий год
        return currentYear - birthYear;
    }


    public String toString()
    {
        return "Имя: " + firstName + " Фамилия: " + lastName + " Возраст: " + birthYear;
    }
    public static void main(String[] args) {
        Person person = new Person("Иван", "Иванов", 2005);
        System.out.println("Возраст: " + person.getAge());
        System.out.println(person);

        System.out.println(person.toString());
    }
}