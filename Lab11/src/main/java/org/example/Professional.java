package org.example;

public class Professional {
    private String name;
    private int experience;
    private double salary;

    public Professional(String name, int experience, double salary) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public double getSalary() {
        return salary;
    }

    public void work() {
        System.out.println(name + " работает");
    }

    public void work(int hours) {
        System.out.println(name + " работает " + hours + " часов");
    }

    public void work(String project) {
        System.out.println(name + " работает над проектом " + project);
    }

    public String getResponsibility() {
        return "Общая ответственность";
    }
}