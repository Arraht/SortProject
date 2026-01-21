package project.sort;

import java.util.Comparator;

public class EntityComparator implements Comparator<Entity> {

    @Override
    public int compare(Entity e1, Entity e2){
        if (e1.getPriority() != e2.getPriority()){
            return Integer.compare(e2.getPriority(), e1.getPriority());
        }

        int nameComp = e1.getName().compareTo(e2.getName());
        if (nameComp != 0){
            return nameComp;
        }

        return Integer.compare(e1.getId(), e2.getId());
    }


}
