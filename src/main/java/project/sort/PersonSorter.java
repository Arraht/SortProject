package project.sort;

import java.util.ArrayList;

public class PersonSorter {
    public void sortAndPrintPersons() {
        ArrayList<Person> entities = new ArrayList<>();
        entities.add(new Person(1L, "Alice", 3));
        entities.add(new Person(2L, "Bob", 1));
        entities.add(new Person(3L, "Petr", 2));
        entities.add(new Person(4L, "Charlie", 4));

        entities.sort(new EntityComparator());

        for (Person entity : entities) {
            System.out.println(entity);
        }
    }
}