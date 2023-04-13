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

        ClassTechmasterHandle classTechmasterHandle = new ClassTechmasterHandle();
        ClassTechmaster classTechmaster = classTechmasterHandle.inputClassTechmaster(scanner);

        Techmaster techmaster = new Techmaster(manager,teacher,classTechmaster);
        System.out.println("Thông tin trung tâm TechMaster: ");
        System.out.println(techmaster);
        //Add
        StudentHandle studentHandle = new StudentHandle();
        Student student = studentHandle.addStudent(scanner);
        System.out.println(techmaster);
        //Edit
        studentHandle.editStudentByID(scanner,students);
        System.out.println(techmaster);
        //Xóa
        studentHandle.deleteStudent(scanner,students);
        System.out.println(techmaster);
    }
}