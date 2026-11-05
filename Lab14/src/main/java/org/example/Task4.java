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

public class Task4 {
    public static void main(String[] args) {
        Path path = Paths.get("salinity.txt");

        try (BufferedReader console = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));
             BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            System.out.println("Введите 15 вещественных значений солёности воды:");
            for (int i = 0; i < 5; i++) {
                System.out.print((i + 1) + ": ");
                String line = console.readLine();
                try {
                    double value = Double.parseDouble(line.trim().replace(',', '.'));
                    writer.write(String.valueOf(value));
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

        List<Double> values = new ArrayList<>();
        try {
            for (String s : Files.readAllLines(path, StandardCharsets.UTF_8)) {
                if (!s.isBlank()) values.add(Double.parseDouble(s.trim()));
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
            return;
        }

        double sum = 0;
        for (double v : values) sum += v;
        double avg = values.isEmpty() ? 0 : sum / values.size();

        System.out.println("\nЗначения: " + values);
        System.out.printf("Средняя солёность: %.4f%n", avg);
    }
}