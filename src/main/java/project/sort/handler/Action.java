package project.sort.handler;

import lombok.experimental.UtilityClass;
import project.sort.files.FilePath;
import project.sort.person.Person;
import project.sort.person.PersonSorter;
import project.sort.sort.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@UtilityClass
class Action {
    private static final List<Person> people = new ArrayList<>();
    private static final Sort person = new PersonSorter();
    private static final String filePath = FilePath.FILE_PATH.getValue();

    public void manualInput(Scanner sc) {
        System.out.println("Сколько людей вы хотите добавить?");
        String data = sc.nextLine();
        if (Check.checkIsZeroOrIsNotInt(data)) {
            manualInput(sc);
            return;
        }
        Check.validateManualEntry(data, sc, people);
        person.sort(people);
        System.out.println(people);
        people.clear();
    }

    public void enterFile(Scanner sc) {
        System.out.println("Пожалуйста, ведите название файла");
        String input = filePath + sc.nextLine().trim().replace('\\', '/') + ".txt";
        if (Check.checkPath(input) != null) {
            System.out.println("Содержимое файла: " + Check.checkPath(input));
            System.out.println("Вызываем метод валидации данных");
        } else {
            enterFile(sc);
        }
    }

    public void generateData(Scanner sc) {
        System.out.println("Сколько людей вы хотите добавить?");
        String input = sc.nextLine();
        if (Check.checkIsZeroOrIsNotInt(input)) {
            generateData(sc);
        } else {
            System.out.println(person.createBySize(Integer.parseInt(input)));
            people.clear();
        }
    }
}