package handle;

import entity.ClassTechmaster;
import entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassTechmasterHandle {
    public ClassTechmaster inputClassTechmaster(Scanner scanner){
        System.out.println("Mời bạn nhập môn học: ");
        String subject = scanner.nextLine();
        System.out.println("Bạn muốn tạo ra bn học sinh: ");
        int n = Integer.parseInt(scanner.nextLine());
        StudentHandle studentHandle = new StudentHandle();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Student student = studentHandle.inputStudent(scanner);
            students.add(student);
        }
        ClassTechmaster classTechmaster = new ClassTechmaster(subject,students);
        return classTechmaster;
    }
}
