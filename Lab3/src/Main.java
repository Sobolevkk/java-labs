import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("====== Задание 1  ======");
        task1();

        System.out.println("\n====== Задание 2 ======");
        task2();

        System.out.println("\n====== Задание 3 ======");
        task3();

        System.out.println("\n====== Задание 4  ======");
        task4();
    }

    public static void task1() {
        String text = "Университет";
        System.out.println("Исходная строка: " + text);

        if (text.length() >= 5) {
            String result = text.substring(5);
            System.out.println("Подстрока с 5-го символа: " + result);
        } else {
            System.out.println("Строка слишком короткая (меньше 5 символов).");
        }
    }

    public static void task2() {
        String sentence = "Я изучаю программирование на языке Java";
        System.out.println("Предложение: " + sentence);

        String[] words = sentence.split("\\s+");

        String shortestWord = words[0];
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Zа-яА-ЯёЁ]", "");

            if (cleanWord.length() > 0 && cleanWord.length() < shortestWord.length()) {
                shortestWord = cleanWord;
            }
        }

        System.out.println("Самое короткое слово: " + shortestWord);
    }

    public static void task3() {
        Employee[] employees = {
                new Employee("Соболев", 125000.50),
                new Employee("Иванов", 95000.753),
                new Employee("Александров", 89400.0)
        };

        Report.generateReport(employees);
    }

    public static void task4() {
        String text = "aAa aBa aCa aDa aEa aFa aGa aEEa";
        System.out.println("Исходная строка: " + text);


        Pattern pattern = Pattern.compile("a[D-Z]{1,2}a");
        Matcher matcher = pattern.matcher(text);

        System.out.print("Найденные совпадения: ");
        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
            found = true;
        }
        if (!found) {
            System.out.print("совпадений не найдено.");
        }
        System.out.println();
    }
}

class Employee {
    String fullname;
    double salary;

    public Employee(String fullname, double salary) {
        this.fullname = fullname;
        this.salary = salary;
    }
}

class Report {
    public static void generateReport(Employee[] employees) {
        System.out.println("--- Отчет по заработной плате ---");
        System.out.printf("%-15s %10s%n", "ФИО", "Зарплата");
        for (Employee emp : employees) {

                System.out.printf("%-15s %10.2f%n", emp.fullname, emp.salary);
        }
        System.out.println("---------------------------------");
    }
}