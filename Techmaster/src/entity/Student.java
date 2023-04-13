package entity;

public class Student {
    private static int autoId;
    private int id;
    private int age;
    private String name;
    private String rating;


    public Student(int age, String name, String rating) {
        this.age = age;
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
