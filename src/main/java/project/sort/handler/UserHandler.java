package project.sort.handler;

import project.sort.person.Person;
import project.sort.person.PersonSorter;
import project.sort.exceptoins.FileNotFoundException;
import project.sort.exceptoins.InvalidException;
import project.sort.sort.Sort;
import project.sort.validator.EmailValidator;
import project.sort.validator.NameValidator;
import project.sort.validator.PasswordValidator;
import project.sort.validator.Validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserHandler {
    private static boolean isRunning = true;
    private static final Scanner sc = new Scanner(System.in);
    private static final Validator nameValidator = new NameValidator();
    private static final Validator emailValidator = new EmailValidator();
    private static final Validator passwordValidator = new PasswordValidator();
    private static final List<Person> people = new ArrayList<>();

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
                case "2" -> manualInput();
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

    private static void manualInput() {
        System.out.println("Сколько людей вы хотите добавить?");
        String data = sc.nextLine();
        if (isNotInt(data) || isZero(Integer.parseInt(data))) {
            manualInput();
            return;
        }
        int size = Integer.parseInt(data);
        for (int i = 0; i < size; i++) {
            System.out.print("Введите имя: ");
            String name = sc.nextLine();
            if (!nameValidator.validate(name)) {
                System.out.println("Имя должно содержать больше 2 символов и состоять из русских или английский букв.");
                i--;
                continue;
            }
            System.out.print("Введите почту: ");
            String email = sc.nextLine();
            if (!emailValidator.validate(email)) {
                System.out.println("Проверьте правильность написания почты.");
                i--;
                continue;
            }
            System.out.print("Введите пароль: ");
            String password = sc.nextLine();
            if (!passwordValidator.validate(password)) {
                System.out.println("Пароль должен состоять минимум из 8ми символов, " +
                        "включать хотя бы одну маленькую и одну большую английскую букву.");
                i--;
                continue;
            }
            people.add(Person.builder()
                    .name(name)
                    .password(password)
                    .mail(email)
                    .build());
            System.out.println("Пользователь успешно сохранён!");
            System.out.println(people);
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
        System.out.println("Сколько людей вы хотите добавить?");
        String input = sc.nextLine();
        if (isNotInt(input)) {
            generateData();
            return;
        }
        int size = Integer.parseInt(input);
        if (isZero(size)) {
            generateData();
        } else {
            Sort person = new PersonSorter();
            System.out.println(person.createBySize(size) + "\nВызов сортировки");
        }
    }

    private static boolean isNotInt(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Необходимо ввести целое число!");
            return true;
        }
    }

    private static boolean isZero(Integer number) {
        if (number.equals(0)) {
            System.out.println("Число не может быть нулём.");
            return true;
        } else {
            return false;
        }
    }
}
