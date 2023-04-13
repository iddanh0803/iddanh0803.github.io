package entity;

import java.util.ArrayList;

public class ClassTechmaster {
    private String subject;
    private ArrayList<Student>students;

    public ClassTechmaster(String subject, ArrayList<Student> students) {
        this.subject = subject;
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "ClassTechmaster{" +
                "subject='" + subject + '\'' +
                ", students=" + students +
                '}';
    }
}
