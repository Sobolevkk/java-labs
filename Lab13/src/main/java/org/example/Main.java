package org.example;

import org.example.exception.InvalidMagazineDataException;
import org.example.exception.MagazineNotFoundException;
import org.example.exception.SubscriptionException;
import org.example.model.Magazine;
import org.example.service.MagazineService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final String LOG_FILE = "magazine_log.txt";

    public static void main(String[] args) {

        MagazineService service = new MagazineService();


        try {
            Magazine n = new Magazine("National Geographic", "NG Media", -245, 128, 450.0);

        } catch (InvalidMagazineDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        System.out.println("--- 1. Создание журналов ---");
        createMagazine(service, "National Geographic", "NG Media", 245, 128, 450.0);
        createMagazine(service, "Forbes", "Forbes Inc.", -12, 96, 320.0);
        createMagazine(service, "Мир Фантастики", "TechInsider", 8, 80, 190.0);

        createMagazine(service, "", "Publisher", 1, 50, 100);
        createMagazine(service, "Test", "Pub", 0, 50, 100);
        createMagazine(service, "Test2", "Pub", 1, -5, 100);
        createMagazine(service, "Test3", "Pub", 1, 50, -10);
        createMagazine(service, "Forbes", "Forbes Inc.", 12, 96, 320.0);

        System.out.println("\nСоздано журналов: " + service.size());

        System.out.println("\n--- 2. Подписка на журналы ---");
        try {
            service.subscribe("National Geographic", 245, "Иван Иванов");
            service.subscribe("National Geographic", 245, "Пётр Петров");
            service.subscribe("Forbes", 12, "Анна Смирнова");
            service.subscribe("Мир Фантастики", 8, "Ольга Кузнецова");

        } catch (MagazineNotFoundException | SubscriptionException e) {
            System.err.println("Ошибка при подписке: " + e.getMessage());
        } finally {
            System.out.println("Блок finally: подписка завершена.");
        }

        try {
            service.subscribe("National Geographic", 245, "Иван Иванов");
        } catch (MagazineNotFoundException e) {
            System.out.println("Журнал не найден: " + e.getMessage());
        } catch (SubscriptionException e) {
            System.out.println("Ошибка подписки [" + e.getOperation() + "]: " + e.getMessage()
                    + " (подписчик: " + e.getSubscriber() + ")");
        }

        try {
            service.subscribe("Несуществующий", 1, "Тест");
        } catch (MagazineNotFoundException e) {
            System.out.println("Журнал не найден (title=" + e.getTitle() + "): " + e.getMessage());
        }

        System.out.println("\n--- 3. Отписка ---");
        try {
            service.unsubscribe("National Geographic", 245, "Пётр Петров");
            System.out.println("Пётр Петров успешно отписан.");
        } catch (MagazineNotFoundException e) {
            System.out.println("Журнал не найден: " + e.getMessage());
        } catch (SubscriptionException e) {
            System.out.println("Ошибка отписки: " + e.getMessage());
        }

        try {
            service.unsubscribe("Forbes", 12, "Несуществующий Подписчик");
        } catch (MagazineNotFoundException | SubscriptionException e) {
            System.out.println("Ошибка отписки: " + e.getMessage());
        }

        System.out.println("\n--- 4. Изменение цены ---");
        try {
            Magazine m = service.findByTitleAndIssue("Forbes", 12);
            m.setPrice(350.0);
            System.out.println("Новая цена Forbes: " + m.getPrice());
            m.setPrice(-1);
        } catch (MagazineNotFoundException e) {
            System.out.println("Журнал не найден: " + e.getMessage());
        } catch (InvalidMagazineDataException e) {
            System.out.println("Ошибка данных (поле " + e.getFieldName() + "="
                    + e.getInvalidValue() + "): " + e.getMessage());
        } finally {
            System.out.println("finally: блок изменения цены завершён.");
        }

        System.out.println("\n--- 5. Список журналов ---");
        service.getAll().forEach(System.out::println);

        System.out.println("\n--- 6. Сохранение отчёта (try-with-resources) ---");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE))) {
            writer.write("Отчёт по журналам:\n");
            for (Magazine m : service.getAll()) {
                writer.write(m.toString());
                writer.newLine();
            }
            System.out.println("Отчёт сохранён в " + LOG_FILE);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла: " + e.getMessage());
        } finally {
            System.out.println("finally: работа с файлом завершена.");
        }

        System.out.println("\n========== ПРОГРАММА ЗАВЕРШЕНА ==========");
    }

    private static void createMagazine(MagazineService service, String title, String publisher,
                                       int issueNumber, int pages, double price) {
        try {
            Magazine m = new Magazine(title, publisher, issueNumber, pages, price);
            service.addMagazine(m);
            System.out.println("  ✅ Создан: " + m.getTitle() + " #" + m.getIssueNumber());
        } catch (InvalidMagazineDataException e) {
            System.out.println("  ❌ Ошибка данных (поле='" + e.getFieldName()
                    + "', значение=" + e.getInvalidValue() + "): " + e.getMessage());
        }
    }


}