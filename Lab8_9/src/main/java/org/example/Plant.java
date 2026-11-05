package org.example;

public class Plant {
    private String name;
    private double height;
    private String type;

    public Plant(String name, double height, String type) {
        this.name = name;
        this.height = height;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void grow() {
        System.out.println(name + " растет.");
    }

    public void displayInfo() {
        System.out.printf("Название: %s | Высота: %.2f м | Тип: %s%n",
                name, height, type);
    }

    public void test1(){

    }
}