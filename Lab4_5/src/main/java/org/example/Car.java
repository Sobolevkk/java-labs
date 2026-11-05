package org.example;

class Car {
    private String model;
    private FuelType fuelType;

    public Car(String model, FuelType fuelType) {
        this.model = model;
        this.fuelType = fuelType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public String getModel() {
        return model;
    }
}
