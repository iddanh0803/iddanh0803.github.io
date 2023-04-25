import entity.Employee;
import entity.Manager;
import entity.Saler;
import handle.EmployeeHandle;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();
        Menu menu = new Menu();
        menu.showMenu(scanner,employees);
    }
}