package org.example;

public class Flower extends Plant {
    private String bloomColor;

    public Flower(String name, double height, String type, String bloomColor) {
        super(name, height, type);
        this.bloomColor = bloomColor;
    }

    public String getBloomColor() {
        return bloomColor;
    }

    public void setBloomColor(String bloomColor) {
        this.bloomColor = bloomColor;
    }

    @Override
    public void grow() {
        System.out.println(getName() + ": Растет быстро");
    }

    public void bloom() {
        System.out.println("Цветок \"" + getName() + "\" цветет цветом: " + bloomColor);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Цвет цветения: " + bloomColor);
    }
}