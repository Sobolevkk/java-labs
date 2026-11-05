package org.example;

public class Main {
    public static void main(String[] args) {
        Doctor doc = new Doctor("Айболит", 12, 1800.0, "Хирургия");
        Engineer eng = new Engineer("Сергей", 7, 2200.0, "Робототехника");

        System.out.println("=== 1. СТАТИЧЕСКИЙ ПОЛИМОРФИЗМ (ПЕРЕГРУЗКА МЕТОДОВ) ===\n");
        doc.work();
        doc.work(8);
        doc.work("Спасение животных");
        doc.work(15, "Травматология");
        System.out.println();

        eng.work();
        eng.work(10);
        eng.work("Марсоход-2026");
        eng.work("Схема питания платы", 75.5);

        System.out.println("\n=== 2. ДИНАМИЧЕСКИЙ ПОЛИМОРФИЗМ (ПЕРЕОПРЕДЕЛЕНИЕ МЕТОДОВ) ===\n");
        Professional[] staff = new Professional[3];
        staff[0] = new Professional("Стажер", 1, 500.0);
        staff[1] = doc;
        staff[2] = eng;

        for (Professional p : staff) {
            System.out.println("Сотрудник: " + p.getName() + " | Ответственность: " + p.getResponsibility());
        }

        System.out.println("\n=== 3. ПРОВЕРКА ТИПОВ (INSTANCEOF) ===\n");
        for (Professional p : staff) {
            if (p instanceof Doctor d) {
                System.out.println(d.getName() + " является врачом, специализация: " + d.getSpecialization());
            } else if (p instanceof Engineer e) {
                System.out.println(e.getName() + " является инженером, отрасль: " + e.getField());
            } else {
                System.out.println(p.getName() + " — базовый специалист без узкого профиля");
            }
        }
    }
}