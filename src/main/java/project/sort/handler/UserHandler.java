package project.sort.handler;

import project.sort.person.PersonSorter;
import project.sort.exceptoins.FileNotFoundException;
import project.sort.exceptoins.InvalidException;
import project.sort.sort.Sort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class UserHandler {
    private static boolean isRunning = true;
    private static final Scanner sc = new Scanner(System.in);
    private static final Sort person = new PersonSorter();

    public static void run() {
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
                case "1" -> enterFile();
                case "2" -> {
                    System.out.println("Введите данные для сортировки: ");
                    String data = sc.nextLine();
                    System.out.println("Вызываем метод валидации данных");
                }
                case "3" -> generateData();
                case "4" -> {
                    System.out.println("Завершаем программу.");
                    isRunning = false;
                }
                default -> System.out.println("Удостоверьтесь в правильности ввода.");
            }
            System.out.println();
        }
    }

    private static String checkPath(String input) {
        try {
            Path path = Paths.get(input);
            return Files.readString(path);
        } catch (NoSuchFileException r) {
            throw new FileNotFoundException("Такого файла не существует.");
        } catch (IOException e) {
            throw new InvalidException("Что-то не так");
        }
    }

    private static void enterFile() {
        System.out.println("Пожалуйста, ведите название файла");
        String input = "src/main/java/project/sort/files/" +
                sc.nextLine().trim().replace('\\', '/') + ".txt";
        System.out.println("Содержимое файла: " + checkPath(input));
        System.out.println("Вызываем метод валидации данных");
    }

    private static void generateData() {
        System.out.println("Введите желаемую длину массива.");
        String input = sc.nextLine();
        int size = 0;

        try {
            size = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Необходимо ввести целое число!");
            generateData();
        }

        if (size == 0) {
            System.out.println("Массив не может быть пустым!");
            generateData();
        } else {
            System.out.println(person.createBySize(size) + "\nВызов сортировки");
        }
    }
}
