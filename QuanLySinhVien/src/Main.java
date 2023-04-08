import entity.Student;
import handle.StudentHandle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập số lượng student muốn tạo: ");
        int n = Integer.parseInt(scanner.nextLine());
        Student[] students = new Student[n];
        StudentHandle studentHandle = new StudentHandle();
        for (int i = 0; i < n; i++) {
            Student student = studentHandle.createStudent(scanner, i);
            //Lưu student vào trong array
            students[i] = student;
        }
        studentHandle.dislayStudent(students);
        studentHandle.getPercent(students);
    }
}