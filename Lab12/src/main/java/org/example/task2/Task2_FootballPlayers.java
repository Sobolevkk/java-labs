package org.example.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task2_FootballPlayers {

    public static void printPlayers(List<FootballPlayer> players, int rating) {
        System.out.println("\n--- Футболисты с рейтингом " + rating + " ---");
        boolean found = false;
        for (FootballPlayer p : players) {
            if (p.getRating() == rating) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Игроков с таким рейтингом не найдено.");
        }
    }

    public static void main(String[] args) {
        List<FootballPlayer> players = new ArrayList<>();
        players.add(new FootballPlayer(1, "Лионель Месси", "Нападающий", 4, Arrays.asList(5, 5, 4, 5, 5)));
        players.add(new FootballPlayer(2, "Килиан Мбаппе", "Нападающий", 3, Arrays.asList(4, 5, 4, 4, 5)));
        players.add(new FootballPlayer(3, "Лука Модрич", "Полузащитник", 4, Arrays.asList(4, 4, 3, 4, 4)));
        players.add(new FootballPlayer(4, "Эрлинг Холанн", "Нападающий", 3, Arrays.asList(5, 4, 5, 4, 4)));
        players.add(new FootballPlayer(5, "Харри Магуайр", "Защитник", 3, Arrays.asList(2, 3, 2, 3, 2)));
        players.add(new FootballPlayer(6, "Алиссон Бекер", "Вратарь", 3, Arrays.asList(3, 3, 3, 2, 3)));
        players.add(new FootballPlayer(7, "Кевин Де Брёйне", "Полузащитник", 4, Arrays.asList(5, 4, 5, 5, 4)));


        System.out.println("\n================ ОПЕРАЦИЯ 1: СРЕДНИЙ БАЛЛ > 3 ================");
        for (FootballPlayer p : players) {
            if (p.getAverageMatchRating() > 3.0) {
                System.out.printf("ID: %d | %-16s | Ср. балл: %.2f%n",
                        p.getId(), p.getName(), p.getAverageMatchRating());
            }
        }

        System.out.println("\n================ ОПЕРАЦИЯ 2: ПОВЫШЕНИЕ РЕЙТИНГА ================");
        for (FootballPlayer p : players) {
            if (p.getAverageMatchRating() >= 4.0) {
                int oldRating = p.getRating();
                p.setRating(oldRating + 1);
                System.out.println(p.getName() + " (ср. балл: " + String.format("%.2f", p.getAverageMatchRating()) +
                        ") -> рейтинг повышен с " + oldRating + " до " + p.getRating());
            }
        }

        System.out.println("\n================ ОПЕРАЦИЯ 3: ПЕЧАТЬ ПО РЕЙТИНГУ ================");
        printPlayers(players, 4);
        printPlayers(players, 5);

        System.out.println("\n================ ОПЕРАЦИЯ 4: СОРТИРОВКА И ВЫВОД ================");
        players.sort(
                Comparator.comparingDouble(FootballPlayer::getAverageMatchRating).reversed()
                        .thenComparing(FootballPlayer::getName, Comparator.reverseOrder())

        );
                  System.out.println("=================================");


        System.out.println(String.format("%-5s | %-18s | %s", "ID", "ИМЯ", "СРЕДНИЙ РЕЙТИНГ"));
        System.out.println("----------------------------------------------");
        for (FootballPlayer p : players) {
            System.out.printf("%-5d | %-18s | %.2f%n", p.getId(), p.getName(), p.getAverageMatchRating());
        }
    }
}