package org.example;

public class Building {
    private String address;
    private int floors;
    private double totalArea;

    public Building(String address, int floors, double totalArea) {
        this.address = address;
        this.floors = floors;
        this.totalArea = totalArea;
    }

    public int getFloors() { return floors; }
    public double getTotalArea() { return totalArea; }
    public String getAddress() { return address; }

    public static void main(String[] args) {
        Building[] buildings = {
                new Building("Улица 1", 5, 1200.5),
                new Building("Улица 2", 12, 5400.0),
                new Building("Улица 3", 3, 800.0),
                new Building("Улица 4", 25, 15000.0),
                new Building("Улица 5", 9, 3200.0),
                new Building("Улица 6", 16, 9000.0)
        };

        Building maxFloorsBuilding = buildings[0];
        Building maxAreaBuilding = buildings[0];

        for (Building b : buildings) {
            if (b.getFloors() > maxFloorsBuilding.getFloors()) {
                maxFloorsBuilding = b;
            }
            if (b.getTotalArea() > maxAreaBuilding.getTotalArea()) {
                maxAreaBuilding = b;
            }
        }

        System.out.println("Здание с максимальным количеством этажей: " + maxFloorsBuilding.getAddress() + " (" + maxFloorsBuilding.getFloors() + " этажей)");
        System.out.println("Здание с максимальной площадью: " + maxAreaBuilding.getAddress() + " (" + maxAreaBuilding.getTotalArea() + " кв.м.)");
    }
}