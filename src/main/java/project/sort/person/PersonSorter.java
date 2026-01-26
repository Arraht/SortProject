package project.sort.person;

import net.datafaker.Faker;
import project.sort.sort.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PersonSorter implements Sort {


    @Override
    public List<Person> sort(List<Person> people) {
        PersonComparator personComparator = new PersonComparator();
        people.sort(personComparator);
        return people;
    }

    @Override
    public List<Person> createBySize(int size) {
        List<Person> people = new ArrayList<>();
        Faker faker = new Faker(new Locale("en"));
        for (int i = 0; i < size; i++) {
            people.add(Person.builder()
                    .name(faker.name().firstName())
                    .password(faker
                            .internet()
                            .password(8,
                                    12,
                                    true,
                                    true,
                                    false))
                    .mail(faker.internet().emailAddress())
                    .build());
        }
        return sort(people);
    }
}