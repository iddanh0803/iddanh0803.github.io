package handle;

import entity.Employee;
import entity.Manager;
import entity.Saler;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeHandle {
    public Saler inpuSaler(Scanner scanner){
        System.out.println("Mời bạn nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập lương: ");
        int salary = Integer.parseInt(scanner.nextLine());
        return new Saler(name,salary);
    }
    public Manager inputManager(Scanner scanner){
        System.out.println("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập lương: ");
        int salary = Integer.parseInt(scanner.nextLine());
        return new Manager(name, salary);
    }


    public void deleteEmployee(Scanner scanner, ArrayList<Employee> employees){
        System.out.println("Mời bạn nhập tên nhân viên muốn xóa: ");
        String name = scanner.nextLine();
        boolean checkName = false;
        int delete = -1;
        for (int i = 0; i <employees.size() ; i++) {
            if (employees.get(i).getName().equalsIgnoreCase(name)){
                checkName = true;
                delete = i;
                break;
            }
        }
        if (checkName = false) System.out.println("Không tìm thấy nhân viên nào.");
        else{
            employees.remove(delete);
        }
    }
    public void editEmployee(Scanner scanner, ArrayList<Employee> employees) {
        System.out.println("Nhập ID nhân viên muốn sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean checkId = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                System.out.println("Nhập thông tin muốn sửa: ");
                System.out.println("Tên: ");
                String name = scanner.nextLine();
                employees.get(i).setName(name);
                System.out.println("Lương: ");
                double salary = Double.parseDouble(scanner.nextLine());
                employees.get(i).setSalary(salary);
            }
        }
    }
}
