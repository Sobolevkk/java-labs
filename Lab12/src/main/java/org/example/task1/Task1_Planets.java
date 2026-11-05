package org.example.task1;

import java.sql.SQLOutput;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Iterator;
public class Task1_Planets {
    public static void main(String[] args) {
        Map<String, Planet> planetMap = new LinkedHashMap<>();

        Terrestrial mercury = new Terrestrial("Меркурий", 1, 0.055, "Крайне разреженная");
        Terrestrial venus = new Terrestrial("Венера", 2, 0.815, "CO2, Азот");
        Terrestrial earth = new Terrestrial("Земля", 3, 1.0, "Азот, Кислород");
        planetMap.put(mercury.getName(), mercury);
        planetMap.put(venus.getName(), venus);
        planetMap.put(earth.getName(), earth);

        GasGiant jupiter = new GasGiant("Юпитер", 4, 317.8, true);
        GasGiant saturn = new GasGiant("Сатурн", 5, 95.2, true);
        GasGiant uranus = new GasGiant("Уран", 6, 14.5, true);
        planetMap.put(jupiter.getName(), jupiter);
        planetMap.put(saturn.getName(), saturn);
        planetMap.put(uranus.getName(), uranus);

        Dwarf pluto = new Dwarf("Плутон", 7, 0.0022, 5);
        Dwarf ceres = new Dwarf("Церера", 8, 0.00015, 0);
        planetMap.put(pluto.getName(), pluto);
        planetMap.put(ceres.getName(), ceres);

        System.out.println("=== СПИСОК ПЛАНЕТ В MAP ===");
        for (Map.Entry<String, Planet> entry : planetMap.entrySet()) {
            System.out.println("Ключ: [" + entry.getKey() + "] ==> " + entry.getValue());
        }

        System.out.println("================================================");
        Iterator<Map.Entry<String, Planet>> iterator = planetMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Planet> entry = iterator.next();
            System.out.println("Ключ: [" + entry.getKey() + "] ==> " + entry.getValue());
        }
        System.out.println("\nВсего объектов в коллекции Map: " + planetMap.size());


        }
    public void Print(int a) {
    }

    public void Print(int a, String b)
    {

    }

}