package project.sort.handler;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.InvalidPathException;
import java.util.Scanner;

public class UserHandler {
    public static void run()  {
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
                    String input = sc.nextLine().trim().replace('\\', '/');
                    Path path;
                    try {
                        path = Paths.get(input);
                    } catch (InvalidPathException e) {
                        System.out.println("Некорректный путь к файлу\n");
                        continue;
                    }
                    String data;
                    try {
                        data = Files.readString(path);
                    } catch (NoSuchFileException r) {
                        System.out.println("Такого файла не существует.\n");
                        continue;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
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
                default -> System.out.println("Удостоверьтесь в правильности ввода.");
            }
            System.out.println();
        }
    }
}
