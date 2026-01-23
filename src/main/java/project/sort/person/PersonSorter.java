package project.sort.person;

import project.sort.sort.Sort;

import java.util.ArrayList;
import java.util.List;

public class PersonSorter implements Sort {
    private static final ArrayList<Person> people = new ArrayList<>();

    @Override
    public void sortAl() {
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
    public Integer createAndCountSize() {
        people.add(new Person("John", "jonh!123", "john@gmail.com"));
        people.add(new Person("Bob", "Boss!153", "Bob@gmail.com"));
        people.add(new Person("Petr", "Shestr15", "Petr@gmail.com"));
        people.add(new Person("Charlie", "Winner", "Charlie@gmail.com"));
        people.add(new Person("Petr", "ShesLot", "Bob@gmail.com"));
        return people.size();
    }
}