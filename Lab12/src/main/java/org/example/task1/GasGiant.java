package org.example.task1;

class GasGiant extends Planet {
    private boolean rings;

    public GasGiant(String name, int id, double mass, boolean rings) {
        super(name, id, mass);
        this.rings = rings;
    }

    public boolean hasRings() {
        return rings;
    }

    @Override
    public String toString() {
        return "Газовый гигант -> ID: " + getId() +
                ", Имя: " + getName() +
                ", Масса: " + getMass() +
                ", Наличие колец: " + (rings ? "Да" : "Нет");
    }
}
