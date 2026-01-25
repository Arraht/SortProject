package project.sort.person;

import net.datafaker.Faker;
import project.sort.sort.Sort;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PersonSorter implements Sort {
    private final ArrayList<Person> people = new ArrayList<>();

    @Override
    public void sortForCount(int count) {
        List<Person> sublist = new ArrayList<>(people.subList(0, count));
        for (Person entity : sublist) {
            System.out.println(entity);
        }
        people.clear();
        sublist.clear();
    }

    @Override
    public ArrayList<Person> createBySize(int size) {
        Faker faker = new Faker(new Locale("en"));
        for (int i = 0; i < size; i++) {
            String name = faker.name().firstName();
            String email = faker.internet().emailAddress();
            String password = faker.internet().password(8, 12, true, true, false);
            people.add(Person.builder()
                            .name(name)
                            .password(password)
                            .mail(email)
                    .build());
        }
        return people;
    }
}