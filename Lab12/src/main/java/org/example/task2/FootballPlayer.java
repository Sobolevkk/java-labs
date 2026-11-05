package org.example.task2;

import java.util.ArrayList;
import java.util.List;

class FootballPlayer {
    private int id;
    private String name;
    private String position;
    private int rating;
    private List<Integer> matchRatings;

    public FootballPlayer(int id, String name, String position, int rating, List<Integer> matchRatings) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.rating = rating;
        this.matchRatings = matchRatings != null ? new ArrayList<>(matchRatings) : new ArrayList<>();
    }

    public double getAverageMatchRating() {
        if (matchRatings.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int mark : matchRatings) {
            sum += mark;
        }
        return (double) sum / matchRatings.size();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = Math.min(rating, 5);
    }

    public List<Integer> getMatchRatings() {
        return matchRatings;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %-16s | Позиция: %-10s | Рейтинг: %d | Оценки: %s | Средний балл: %.2f",
                id, name, position, rating, matchRatings, getAverageMatchRating());
    }
}
