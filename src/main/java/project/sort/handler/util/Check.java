package project.sort.handler.util;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


@UtilityClass
public class Check {
    private static final Validator nameValidator = new NameValidator();
    private static final Validator emailValidator = new EmailValidator();
    private static final Validator passwordValidator = new PasswordValidator();

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

    public static boolean checkIsZeroOrIsNotInt(String input) {
        try {
            Integer number = Integer.parseInt(input);
            if (number.equals(0)) {
                System.out.println("Число не может быть нулём.");
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Необходимо ввести целое число!");
            return true;
        }
    }
}