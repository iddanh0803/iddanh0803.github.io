package handle;

import entity.Student;

import java.util.Scanner;

public class StudentHandle {
    public Student inputStudent(Scanner scanner){
        System.out.println("Mời bạn nhập tên của học sinh: ");
        String nameStudent = scanner.nextLine();
        System.out.println("Mời bạn nhập tuổi của học sinh: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời ban nhập học lực của học sinh: ");
        String rating = scanner.nextLine();
        Student student = new Student(age,nameStudent,rating);
        return student;
    }
}
