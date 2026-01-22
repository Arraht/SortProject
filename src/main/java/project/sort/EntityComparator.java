package project.sort;

import java.util.Comparator;

public class EntityComparator implements Comparator<Person> {

    @Override
    public int compare(Person e1, Person e2) {
        if (e1.getPriority() != e2.getPriority()) {
            return Integer.compare(e2.getPriority(), e1.getPriority());
        }

        int nameComp = e1.getName().compareTo(e2.getName());
        if (nameComp != 0) {
            return nameComp;
        }

        return Long.compare(e1.getId(), e2.getId());
    }
}