package project.sort;

public class Entity {

    private int id;
    private String name;
    private int priority;

    public Entity(int id, String name, int priority){
        this.id = id;
        this.name = name;
        this.priority = priority;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
