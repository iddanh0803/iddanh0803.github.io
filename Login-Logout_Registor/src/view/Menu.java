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
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose){
            case 1:
                Login login = new Login();
                login.login(scanner);
                login.checkUsername(scanner,users);
                break;
            case 2:
                Register register = new Register();
                register.register(scanner);
                break;
        }
    }
}
