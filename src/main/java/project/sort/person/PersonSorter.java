package project.sort.person;

import net.datafaker.Faker;
import project.sort.sort.Sort;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PersonSorter implements Sort {
    private static ArrayList<Person> people = new ArrayList<>();

    @Override
    public void sortAll() {
        people.sort(new PersonComparator());
        for (Person entity : people) {
            System.out.println(entity);
        }
    }

    @Override
    public void sortForCount(int count) {
        if (count <= 0 || count > people.size()) {
            System.out.println("Неверное количество элементов для сортировки.");
            return;
        }
        List<Person> sublist = new ArrayList<>(people.subList(0, count));
        sublist.sort(new PersonComparator());
        for (int i = 0; i < count; i++) {
            sublist.set(i, people.get(i));
        }
        for (Person entity : sublist) {
            System.out.println(entity);
        }
        people.clear();
        sublist.clear();
    }

    @Override
    public ArrayList<Person> createBySize(int size) {
        if (!people.isEmpty()) {
            people = new ArrayList<>();
        }
        Faker faker = new Faker(new Locale("en"));

        for (int i = 0; i < size; i++) {
            String name = faker.name().firstName();
            String email = faker.internet().emailAddress();
            String password = faker.internet().password(8, 12, true, true, false);

            people.add(new Person(name, password, email));
        }
        return people;
    }
}