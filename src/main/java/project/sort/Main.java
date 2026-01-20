package project.sort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        while (isRunning) {
            System.out.println("""
                    Это приложение поможет вам отсортировать данные.
                    Выберите, источник данных:
                    1 - Загрузить из файла
                    2 - Ввести вручную
                    3 - Заполнить случайным образом
                    4 - Выйти из приложения""");
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("Пожалуйста, ведите путь к файлу");
                    String path = sc.nextLine().trim().replace('\\', '/');
                    String data = Files.readString(Paths.get(path));
                    System.out.println("Содержимое файла: " + data);
                    System.out.println("Вызываем метод валидации данных");
                }
                case "2" -> {
                    System.out.println("Введите данные для сортировки: ");
                    String data = sc.nextLine();
                    System.out.println("Вызываем метод валидации данных");
                }
                case "3" -> {
                    System.out.println("Введите желаемую длину массива: ");
                    String data = sc.nextLine();
                    System.out.println
                            ("Вызываем метод генерации данных для массива длиной " + data + " ед.");
                }
                case "4" -> {
                    System.out.println("Завершаем программу.");
                    isRunning = false;
                }
                case null, default -> System.out.println("Удостоверьтесь в правильности ввода.");
            }
            System.out.println();
        }
    }
}