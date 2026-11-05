package org.example;

public class Doctor extends Professional {
    private String specialization;

    public Doctor(String name, int experience, double salary, String specialization) {
        super(name, experience, salary);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String getResponsibility() {
        return "Здоровье пациентов";
    }

    public void work(int patientsCount, String department) {
        System.out.println(getName() + " принимает " + patientsCount + " пациентов в отделении: " + department);
    }
}