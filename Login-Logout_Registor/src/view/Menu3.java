package view;

import entity.User;
import handle.ForgotPassword;
import handle.Login;
import handle.Register;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu3 {
    public void showMenu3(Scanner scanner, ArrayList<User> users,int index){
        System.out.println("1 - Đăng nhập ");
        System.out.println("2 - Quên mật khẩu ");
        System.out.println("3 - Đăng kí ");
        int option = 0;
        try {
            option = Integer.parseInt(scanner.nextLine());
        }catch (Exception exception){
            System.out.println("Nhập dữ liệu không đúng. ");
        }
        switch (option){
            case 1:
                Login login = new Login();
                login.login(scanner, users);
                break;
            case 2:
                ForgotPassword forgotPassword = new ForgotPassword();
                forgotPassword.forgotPassword(scanner,users,index);
                break;
            case 3:
                Register register = new Register();
                register.inputRegister(scanner,users);
                break;
            default:
                System.out.println("Nhập dữ liệu không đúng. ");
                showMenu3(scanner,users,index);
        }
    }
}
