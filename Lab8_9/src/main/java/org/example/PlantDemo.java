package org.example;

public class PlantDemo {
    public static void main(String[] args) {
        Plant[] plants = new Plant[5];

        plants[0] = new Tree("Дуб", 15.5, "Лиственное", 8.0);
        plants[1] = new Tree("Сосна", 20.0, "Хвойное", 5.5);
        plants[2] = new Tree("Береза", 12.0, "Лиственное", 6.0);
        plants[3] = new Flower("Роза", 0.8, "Кустарник", "красный");
        plants[4] = new Flower("Тюльпан", 0.4, "Травянистое", "желтый");

        Plant plant = new Tree("Дуб", 15.5, "Лиственное", 8.0);
        Tree t = new Tree("Дуб", 15.5, "Лиственное", 8.0);
        System.out.println(plant.getName());

        System.out.println("Демонстрация полиморфизма: grow() \n");
        for (Plant p : plants) {
            p.grow();
            p.displayInfo();
            System.out.println();
        }

        System.out.println("Демонстрация уникальных методов: \n");
        for (Plant p : plants) {
            if (p instanceof Tree) {
                ((Tree) p).cutDown();
            } else if (p instanceof Flower) {
                ((Flower) p).bloom();
            }
        }

        plant.test1();
        t.test2();
        t.test1();

    }
}