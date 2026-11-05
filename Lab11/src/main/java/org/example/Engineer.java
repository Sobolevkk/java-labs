package org.example;

public class Engineer extends Professional {
    private String field;

    public Engineer(String name, int experience, double salary, String field) {
        super(name, experience, salary);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public String getResponsibility() {
        return "Проектирование";
    }

    public void work(String blueprint, double progress) {
        System.out.println(getName() + " чертит " + blueprint + " (прогресс: " + progress + "%)");
    }
}