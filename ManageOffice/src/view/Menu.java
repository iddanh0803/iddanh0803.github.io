package view;

import entity.Employee;
import entity.Manager;
import entity.Saler;
import handle.EmployeeHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void showMenu(Scanner scanner, ArrayList<Employee> employees){
        EmployeeHandle employeeHandle = new EmployeeHandle();
        int option = 0;
        System.out.println("1. Nhập và xuất danh sách nhân viên\n" +
                "2. Xóa nhân viên hoặc cập nhật thông tin nhân viên\n" +
                "3. Tìm kiếm nhân viên theo lương");
        System.out.println("Mời bạn chọn: ");
        try{
            option = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Nhập dữ liệu không đúng.");
        }
        switch (option){
            case 1:
                System.out.println("Mời bạn nhập số lượng nhân viên: ");
                int n = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < n; i++) {
                    Saler saler = employeeHandle.inpuSaler(scanner);
                    employees.add(saler);
                }
                System.out.println("Mời bạn nhập số lượng trưởng phòng: ");
                int numberOfManager = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < numberOfManager; i++) {
                    Manager manager = employeeHandle.inputManager(scanner);
                    employees.add(manager);
                }
                System.out.println(employees);
                showMenu(scanner,employees);
                break;
            case 2:
                employeeHandle.deleteEmployee(scanner,employees);
                System.out.println(employees);
                employeeHandle.editEmployee(scanner,employees);
                System.out.println(employees);
                showMenu(scanner,employees);
                break;
            case 3:
                int minSalary = 10000;
                for (Employee employee:employees
                     ) {
                    if (employee.getSalary() >= minSalary){
                        System.out.println(employee);
                    }
                }
                break;
            default:
                System.out.println("Nhập dữ liệu không đúng. ");
                showMenu(scanner,employees);
        }
    }
}
