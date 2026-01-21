package project.sort;

import project.sort.handler.UserHandler;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        ArrayList<Entity> entities = new ArrayList<>();
        entities.add(new Entity(1, "Alice", 3));
        entities.add(new Entity(2, "Bob", 1));
        entities.add(new Entity(3, "Alice", 2));
        entities.add(new Entity(4, "Charlie", 4));


        entities.sort(new EntityComparator());



        for (Entity entity: entities){
            System.out.println(entity);
        }
    }

}