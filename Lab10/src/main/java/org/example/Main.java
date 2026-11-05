package org.example;

public class Main {
    public static void main(String[] args) {
        Edible.showFoodCategory();
        System.out.println();

        Edible[] dishes = new Edible[5];
        dishes[0] = new Pasta("Карбонара", 550, "Черный перец");
        dishes[1] = new Pasta("Болоньезе", 600, "Орегано, Базилик");
        dishes[2] = new Pasta("Феттуччине", 480, "Чеснок");
        dishes[3] = new Salad("Цезарь", 350, "Соус Цезарь");
        dishes[4] = new Salad("Греческий", 250, "Оливковое масло");

        System.out.println("=== 1. ПОЛИМОРФИЗМ ЧЕРЕЗ ИНТЕРФЕЙС EDIBLE ===");
        for (Edible dish : dishes) {
            dish.eat();
            System.out.println("Калории порции: " + dish.getCalories() + " ккал\n");
        }

        System.out.println("=== 2. РАБОТА С ИНТЕРФЕЙСОМ SPICEABLE ===");
        for (Edible dish : dishes) {
            if (dish instanceof Spiceable) {
                Spiceable spicedDish = (Spiceable) dish;
                spicedDish.addSpice("Пармезан");
                System.out.println("Текущие добавки/приправы: " + spicedDish.getSpices());
                System.out.println("----------------------------------------------");
            }
        }
    }
}