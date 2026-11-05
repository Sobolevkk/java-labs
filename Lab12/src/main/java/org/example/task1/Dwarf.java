package org.example.task1;

class Dwarf extends Planet {
    private int moons;

    public Dwarf(String name, int id, double mass, int moons) {
        super(name, id, mass);
        this.moons = moons;
    }

    public int getMoons() {
        return moons;
    }

    @Override
    public String toString() {
        return "Карликовая планета -> ID: " + getId() +
                ", Имя: " + getName() +
                ", Масса: " + getMass() +
                ", Спутников: " + moons;
    }
}
