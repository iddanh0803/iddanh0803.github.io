package handle;

import entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<>();
    public Student addStudent(Scanner scanner){
        System.out.println("Thông tin học sinh mà bạn muốn thêm: ");
        int id = (students.size()) + 1;
        System.out.println("Student id: " + id);
        System.out.println("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập học lực: ");
        String rating = scanner.nextLine();
        Student student = new Student(age,name,rating);
        return student;
    }
}
