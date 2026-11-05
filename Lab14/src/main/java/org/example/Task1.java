package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        Path path = Paths.get("favorite_color.txt");

        try {
            List<String> lines = List.of(
                    "Мой любимый цвет: синий",
                    "Оттенок: тёмно-синий (navy)",
                    "Причина: спокойный, ассоциируется с морем и небом",
                    "HEX: #001F5B"
            );
            Files.write(path, lines, StandardCharsets.UTF_8);
            System.out.println("Файл создан: " + path.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка записи файла: " + e.getMessage());
            return;
        }

        File file = path.toFile();
        System.out.println("\n--- Данные о файле ---");
        System.out.println("Имя: " + file.getName());
        System.out.println("Размер: " + file.length() + " байт");
        System.out.println("Последнее изменение: " + file.lastModified());
        System.out.println("Родительский каталог: " + file.getParent());
        System.out.println("Путь: " + file.getPath());
        System.out.println("Абсолютный путь: " + file.getAbsolutePath());
        System.out.println("Существует: " + file.exists());
        System.out.println("Читаемый: " + file.canRead());
        System.out.println("Записываемый: " + file.canWrite());
        System.out.println("Это каталог: " + file.isDirectory());
        System.out.println("Это файл: " + file.isFile());

        System.out.println("\n--- Содержимое файла ---");
        try {
            List<String> content = Files.readAllLines(path, StandardCharsets.UTF_8);
            content.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}