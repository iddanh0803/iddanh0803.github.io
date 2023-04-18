package view;

import entity.User;
import handle.Login;
import handle.Register;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public  void showMenu(Scanner scanner, ArrayList<User> users){
        System.out.println("1 - Đăng nhập ");
        System.out.println("2 - Đặng kí ");
        System.out.println("Mời bạn chọn: ");
        int choose = 0;
        try {
            choose = Integer.parseInt(scanner.nextLine());
        }catch (Exception exception){
            System.out.println("Nhập dữ liệu không đúng.");
        }
        switch (choose){
            case 1:
                Login login = new Login();
                login.login(scanner,users);
                break;
            case 2:
                Register register = new Register();
                register.inputRegister(scanner,users);
                break;
            default:
                System.out.println("Nhập dữ liệu không đúng. ");
                showMenu(scanner,users);
        }
    }
}
