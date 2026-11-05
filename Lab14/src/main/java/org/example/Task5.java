package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        Path path = Paths.get("f5.txt");
        Random random = new Random();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100) - 50);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (int n : numbers) {
                writer.write(String.valueOf(n));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
            return;
        }

        int count = 0;
        List<Integer> read = new ArrayList<>();
        try {
            for (String s : Files.readAllLines(path, StandardCharsets.UTF_8)) {
                if (s.isBlank()) continue;
                int n = Integer.parseInt(s.trim());
                read.add(n);
                if (n % 6 == 0) count++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
            return;
        }

        System.out.println("Числа в файле: " + read);
        System.out.println("Количество чисел, кратных 6: " + count);
    }
}