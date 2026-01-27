package project.sort.handler;

import lombok.experimental.UtilityClass;
import project.sort.person.Person;
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

@UtilityClass
class Check {
    private static final Validator nameValidator = new NameValidator();
    private static final Validator emailValidator = new EmailValidator();
    private static final Validator passwordValidator = new PasswordValidator();
    private static final List<String> invalidLines = new ArrayList<>();
    private static final List<Person> validPersons = new ArrayList<>();

    public static void validateManualEntry(String data, Scanner sc, List<Person> people) {
        for (int i = 0; i < Integer.parseInt(data); i++) {
            System.out.print("Введите имя: ");
            String name = sc.nextLine();
            if (!nameValidator.validate(name)) {
                i--;
                continue;
            }
            System.out.print("Введите почту: ");
            String email = sc.nextLine();
            if (!emailValidator.validate(email)) {
                i--;
                continue;
            }
            System.out.print("Введите пароль: ");
            String password = sc.nextLine();
            if (!passwordValidator.validate(password)) {
                i--;
                continue;
            }
            people.add(Person.builder()
                    .name(name)
                    .password(password)
                    .mail(email)
                    .build());
            System.out.println("Пользователь успешно сохранён!");
        }
    }

    public static String checkPath(String input) {
        try {
            Path path = Paths.get(input);
            return Files.readString(path);
        } catch (NoSuchFileException r) {
            System.out.println("Такого файла не существует.");
            return null;
        } catch (IOException e) {
            System.out.println("Что-то не так");
            return null;
        }
    }

    public static boolean checkIsPositiveAndIsInt(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 1) {
                System.out.println("Число должно быть больше 0");
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Необходимо ввести целое число!");
            return true;
        }
    }

    public static void processLine(String line, int lineNumber) {
        if (line.trim().isEmpty()) {
            invalidLines.add("Строка " + lineNumber + " пустая.");
            return;
        }

        String[] parts = line.split(",", 3);

        if (parts.length < 3) {
            invalidLines.add("Строка №" + lineNumber + ": '" + line +
                    "' - недостаточно данных (нужно 3 поля)");
            return;
        }

        String name = parts[0].trim();
        String email = parts[1].trim();
        String password = parts[2].trim();

        if (nameValidator.validate(name) && emailValidator.validate(email) && passwordValidator.validate(password)) {
            validPersons.add(Person.builder()
                    .name(name)
                    .mail(email)
                    .password(password)
                    .build());
        } else {
            invalidLines.add("Строка №" + lineNumber + ": '" + line + "'");
        }
    }

    public List<Person> getValidPersons() {
        return new ArrayList<>(validPersons);
    }

    public List<String> getInvalidLines() {
        return new ArrayList<>(invalidLines);
    }

    public void clearValidPersons() {
        validPersons.clear();
    }

    public void clearInvalidLines() {
        invalidLines.clear();
    }
}