package org.example.task1;

class Terrestrial extends Planet {
    private String atmosphere;

    public Terrestrial(String name, int id, double mass, String atmosphere) {
        super(name, id, mass);
        this.atmosphere = atmosphere;
    }

    public String getAtmosphere() {
        return atmosphere;
    }

    @Override
    public String toString() {
        return "Земная группа -> ID: " + getId() +
                ", Имя: " + getName() +
                ", Масса: " + getMass() +
                ", Атмосфера: " + atmosphere;
    }
}
