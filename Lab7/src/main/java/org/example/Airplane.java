package org.example;

public class Airplane {
    private String model;
    private int capacity;
    private int range;

    private static int totalPlanes = 0;
    private static int totalCapacity = 0;

    public Airplane(String model, int capacity, int range) {
        this.model = model;
        this.capacity = capacity;
        this.range = range;

        totalPlanes++;
        totalCapacity += capacity;
    }

    public static double getAverageCapacity() {
        if (totalPlanes == 0) return 0;
        return (double) totalCapacity / totalPlanes;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRange() {
        return range;
    }

    public static int getTotalPlanes() {
        return totalPlanes;
    }
}