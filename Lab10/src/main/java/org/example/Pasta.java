package org.example;

public class Pasta implements Edible, Spiceable {
    private String name;
    private int calories;
    private String spices;

    public Pasta(String name, int calories, String spices) {
        this.name = name;
        this.calories = calories;
        this.spices = spices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public void eat() {
        System.out.println("Едим пасту " + name + " (Калорийность: " + calories + " ккал)");
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public void addSpice(String spice) {
        this.spices = this.spices + ", " + spice;
        System.out.println("К пасте " + name + " добавлена специя: " + spice);
    }

    @Override
    public String getSpices() {
        return spices;
    }
}