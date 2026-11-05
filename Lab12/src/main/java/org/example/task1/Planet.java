package org.example.task1;

class Planet {
    private String name;
    private int id;
    private double mass;

    public Planet(String name, int id, double mass) {
        this.name = name;
        this.id = id;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getMass() {
        return mass;
    }

    @Override
    public String toString() {
        return "org.example.task1.Planet [ID=" + id + ", Название='" + name + "', Масса=" + mass + "]";
    }
}
