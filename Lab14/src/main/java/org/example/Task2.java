package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        Path path = Paths.get("f.txt");

        try (BufferedReader console = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));
             BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            System.out.println("Введите 10 целых чисел:");
            for (int i = 0; i < 10; i++) {
                System.out.print((i + 1) + ": ");
                String line = console.readLine();
                try {
                    Integer.parseInt(line.trim());
                    writer.write(line.trim());
                    writer.newLine();
                } catch (NumberFormatException e) {
                    System.out.println("  Не число, повторите ввод.");
                    i--;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
            return;
        }

        List<Integer> numbers = new ArrayList<>();
        try {
            for (String s : Files.readAllLines(path, StandardCharsets.UTF_8)) {
                if (!s.isBlank()) numbers.add(Integer.parseInt(s.trim()));
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
            return;
        }

        System.out.println("\nСчитанные числа: " + numbers);

        long count = numbers.stream()
                .filter(n -> n % 2 != 0 && n % 5 == 0)
                .count();

        System.out.println("Количество чисел, являющихся нечётными и кратными 5: " + count);
    }
}