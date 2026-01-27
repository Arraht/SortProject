package project.sort.handler;

import lombok.experimental.UtilityClass;
import project.sort.files.FilePath;
import project.sort.person.Person;
import project.sort.sort.PersonSorter;
import project.sort.sort.Sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@UtilityClass
class Action {
    private static final List<Person> people = new ArrayList<>();
    private static final Sort person = new PersonSorter();
    private static final String filePath = FilePath.FILE_PATH.getValue();
    private static final List<String> errors = new ArrayList<>();

    public static void manualInput(Scanner sc) {
        System.out.println("Сколько людей вы хотите добавить?");
        String data = sc.nextLine();
        if (Check.checkIsPositiveAndIsInt(data)) {
            manualInput(sc);
            return;
        }
        Check.validateManualEntry(data, sc, people);
        person.sort(people);
        people.forEach(System.out::println);
        people.clear();
    }

    public static void enterFile(Scanner sc) {
        System.out.println("""
                Пожалуйста, ведите название файла из директории '\\sort\\files\\'.
                Данные должны быть записаны через запятую в формате: имя, почта, пароль.
                Каждый пользователь на новой строке.""");
        String input = filePath + sc.nextLine().trim();
        String file = Check.checkPath(input);
        if (file == null) {
            enterFile(sc);
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
                String line;
                int lineNumber = 0;

                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    Check.processLine(line, lineNumber);
                }

            } catch (IOException e) {
                System.err.println("Ошибка чтения файла: " + e.getMessage());
            }

            people.addAll(Check.getValidPersons());
            errors.addAll(Check.getInvalidLines());
            Check.clearValidPersons();
            Check.clearInvalidLines();
        }
        if (!errors.isEmpty()) {
            System.out.println("\nСо следующими данными возникли ошибки: \n" + errors);
        }
        person.sort(people);
        System.out.println("\nСписок отсортированных пользователей:");
        people.forEach(System.out::println);
        people.clear();
    }

    public static void generateData(Scanner sc) {
        System.out.println("Сколько людей вы хотите добавить?");
        String input = sc.nextLine();
        if (Check.checkIsPositiveAndIsInt(input)) {
            generateData(sc);
        } else {
            System.out.println("Список отсортированных пользователей:");
            person.createBySize(Integer.parseInt(input)).forEach(System.out::println);
            people.clear();
        }
    }
}