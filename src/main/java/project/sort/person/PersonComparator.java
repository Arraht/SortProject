package project.sort.person;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person e1, Person e2) {
        int result = e1.getMail().compareTo(e2.getMail());
        if (result != 0) {
            return result;
        }
        result = e1.getPassword().compareTo(e2.getPassword());
        if (result != 0) {
            return result;
        }
        return e1.getName().compareTo(e2.getName());
    }
}