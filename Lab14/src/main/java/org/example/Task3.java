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

public class Task3 {
    public static void main(String[] args) {
        Path f = Paths.get("f3.txt");
        Path g = Paths.get("g3.txt");
        Path h = Paths.get("h3.txt");

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(200) - 100);
        }

        try (BufferedWriter wf = Files.newBufferedWriter(f, StandardCharsets.UTF_8)) {
            for (int n : numbers) {
                wf.write(String.valueOf(n));
                wf.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи f: " + e.getMessage());
            return;
        }

        List<Integer> listG = new ArrayList<>();
        List<Integer> listH = new ArrayList<>();

        try {
            for (String s : Files.readAllLines(f, StandardCharsets.UTF_8)) {
                if (s.isBlank()) continue;
                int n = Integer.parseInt(s.trim());
                if (n % 2 == 0 && n < 50) {
                    listG.add(n);
                } else {
                    listH.add(n);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения f: " + e.getMessage());
            return;
        }

        try (BufferedWriter wg = Files.newBufferedWriter(g, StandardCharsets.UTF_8);
             BufferedWriter wh = Files.newBufferedWriter(h, StandardCharsets.UTF_8)) {

            for (int n : listG) {
                wg.write(String.valueOf(n));
                wg.newLine();
            }
            for (int n : listH) {
                wh.write(String.valueOf(n));
                wh.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи g/h: " + e.getMessage());
            return;
        }

        System.out.println("Исходный список: " + numbers);
        System.out.println("g (чётные и < 50): " + listG);
        System.out.println("h (остальные):     " + listH);
    }
}