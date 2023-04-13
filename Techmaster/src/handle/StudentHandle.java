package handle;

import entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentHandle {
    public Student inputStudent(Scanner scanner) {
        System.out.println("Mời bạn nhập tên của học sinh: ");
        String nameStudent = scanner.nextLine();
        System.out.println("Mời bạn nhập tuổi của học sinh: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời ban nhập học lực của học sinh: ");
        String rating = scanner.nextLine();
        Student student = new Student(age, nameStudent, rating);
        return student;
    }

    public Student addStudent(Scanner scanner) {
        System.out.println("Mời bạn nhập thông tin học sinh muốn thêm: ");
        System.out.println("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập học lực: ");
        String rating = scanner.nextLine();
        Student student = new Student(age, name, rating);
        return student;
    }

    public void editStudentByID(Scanner scanner, ArrayList<Student> students) {
        System.out.println("Nhập id học viên cần sửa:");
        int id = Integer.parseInt(scanner.nextLine());
        boolean checkID = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                System.out.println("Nhập học lực mới muốn sửa");
                String rating = scanner.nextLine();
                students.get(i).setRating(rating);
                ;
                checkID = true;
            }
        }
        if (checkID == false) System.out.println("Không tìm thấy học viên nào");
    }
    public void deleteStudent(Scanner scanner,ArrayList<Student> students){
        System.out.println("Nhập tên học viên cần xóa:");
        String name = scanner.nextLine();
        boolean checkName = false;
        int delete=-1;
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)){
                checkName=true;
                delete= i;
                break;
            }
        }
        if (checkName==false) System.out.println("Không tìm thấy học viên nào");
        else {
            students.remove(delete);
        }
    }

}
