import entity.ClassTechmaster;
import entity.Student;
import entity.Techmaster;
import handle.ClassTechmasterHandle;
import handle.StudentHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Mời bạn nhập quản lý: ");
        String manager = scanner.nextLine();
        System.out.println("Mời bạn nhập giảng viên: ");
        String teacher = scanner.nextLine();

        System.out.println("Mời bạn nhập môn học: ");
        String subject = scanner.nextLine();
        StudentHandle studentHandle = new StudentHandle();
        System.out.println("Mời bạn nhập số học sinh: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Mời bạn nhập vào học viên thứ " + (i+1) + ":" );
            Student student = studentHandle.inputStudent(scanner);
            students.add(student);
        }
        ClassTechmaster classTechmaster = new ClassTechmaster(subject,students);


        Techmaster techmaster = new Techmaster(manager,teacher,classTechmaster);
        System.out.println("Thông tin trung tâm TechMaster: ");
        System.out.println(techmaster);

        //Add
        studentHandle.addStudent(scanner,students);
        System.out.println(techmaster);
        //Edit
        studentHandle.editStudentByID(scanner,students);
        System.out.println(techmaster);
        //Xóa
        studentHandle.deleteStudent(scanner,students);
        System.out.println(techmaster);
    }
}