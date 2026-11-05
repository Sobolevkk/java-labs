package org.example;

public interface Edible {
    void eat();
    int getCalories();

    static void showFoodCategory() {
        System.out.println("Категория: Продукты питания");
    }
}