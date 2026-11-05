package org.example;

public class Salad implements Edible, Spiceable {
    private String name;
    private int calories;
    private String dressing;

    public Salad(String name, int calories, String dressing) {
        this.name = name;
        this.calories = calories;
        this.dressing = dressing;
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

    public String getDressing() {
        return dressing;
    }

    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    @Override
    public void eat() {
        System.out.println("Едим салат " + name + " с заправкой '" + dressing + "' (Калорийность: " + calories + " ккал)");
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public void addSpice(String spice) {
        this.dressing = this.dressing + " + " + spice;
        System.out.println("В заправку салата " + name + " добавлена специя: " + spice);
    }

    @Override
    public String getSpices() {
        return dressing;
    }
}