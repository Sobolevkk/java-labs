package org.example;

public class Editor extends Software {
    private String format;

    public Editor(String name, String version, double price, String format) {
        super(name, version, price);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void install() {
        System.out.println("Установка редактора занимает 5 ГБ");
    }

    @Override
    public String getRequirements() {
        return "Требуется Windows 7, 4 ГБ RAM";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Рабочий формат файлов: " + format);
    }
}