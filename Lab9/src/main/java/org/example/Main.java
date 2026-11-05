package org.example;

public class Main {
    public static void main(String[] args) {
        Software[] softwareList = new Software[5];
        softwareList[0] = new Game("The Witcher 3", "1.32", 39.99, "RPG");
        softwareList[1] = new Game("Cyberpunk 2077", "2.1", 59.99, "Action-RPG");
        softwareList[2] = new Game("Minecraft", "1.20", 26.95, "Sandbox");
        softwareList[3] = new Editor("Adobe Photoshop", "2024", 239.88, "PSD");
        softwareList[4] = new Editor("VS Code", "1.85", 0.0, "TXT/JSON");

        System.out.println("=== ПОЛИМОРФНЫЙ ВЫВОД ДАННЫХ И ТРЕБОВАНИЙ К ПО ===\n");

        for (Software sw : softwareList) {
            sw.displayInfo();
            sw.install();
            System.out.println("Требования: " + sw.getRequirements());
            System.out.println("--------------------------------------------------");
        }
    }
}