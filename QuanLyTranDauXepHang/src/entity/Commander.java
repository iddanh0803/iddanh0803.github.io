package entity;

public class Commander {
    private String name;
    private String position;

    public Commander(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Commander{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
