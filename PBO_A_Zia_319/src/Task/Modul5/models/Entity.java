package Task.Modul5.models;

public abstract class Entity { private int id;
    private String name;

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() { return name; }

    public int getId() {
        return id;
    }
}