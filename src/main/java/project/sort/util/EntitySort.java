package project.sort.util;

import java.util.Comparator;

public class EntitySort implements Comparator<Entity> {
    @Override
    public int compare(Entity a, Entity b) {
        //Шаблон:
        int field1Comp = a.getFieldOne().compareTo(b.getFieldOne());
        if (field1Comp != 0) return field1Comp;

        int field2Comp = a.getFieldTwo().compareTo(b.getFieldTwo());
        if (field2Comp != 0) return field2Comp;

        return a.getFieldThree().compareTo(b.getFieldThree());
    }
}