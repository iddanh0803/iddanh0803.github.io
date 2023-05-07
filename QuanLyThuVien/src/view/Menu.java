package view;

import entity.User;
import handle.UserHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void menuLogin(Scanner scanner, ArrayList<User>users){
        int option = 0;
        System.out.println("1 - Đăng nhập ");
        System.out.println("2 - Đặng kí ");
        System.out.println("Mời bạn chọn: ");
        try{
            option = Integer.parseInt(scanner.nextLine());
        }catch (Exception exception){
            System.out.println("Nhập dữ liệu không đúng.");
        }
        UserHandle userHandle = new UserHandle();
        switch (option){
            case 1:
                userHandle.login(scanner,users);
                break;
            case 2:
                userHandle.createUser(scanner,users);
                System.out.println("Đăng kí thành công.");
                menuLogin(scanner,users);
                break;
            default:
                System.out.println("Nhập dữ liệu không đúng. ");
                menuLogin(scanner,users);
                break;
        }
    }
    public void menuLoginFalse(Scanner scanner, ArrayList<User> users){
        int option = 0;
        System.out.println("1. Đăng nhập lại. ");
        System.out.println("2. Quên mật khẩu.");
        System.out.println("Mời bạn chọn.");
        try{
            option = Integer.parseInt(scanner.nextLine());
        }catch (Exception exception){
            System.out.println("Nhập dữ liệu không đúng.");
        }
        UserHandle userHandle = new UserHandle();
        switch (option){
            case 1:
                userHandle.login(scanner,users);
                break;
            case 2:
                System.out.println("Mời bạn nhập email đã đăng ký: ");
                String email = scanner.nextLine();
                User user = userHandle.findUserByEmail(users,email);
                userHandle.forgotPassword(user,scanner,users);
                break;
            default:
                System.out.println("Nhập dữ liệu không đúng.");
                menuLoginFalse(scanner,users);
                break;
        }
    }
    public void menuLoginSuccess(Scanner scanner, ArrayList<User> users,User user){
        System.out.println("1 - Thay đổi username ");
        System.out.println("2 - Thay đổi email ");
        System.out.println("3 - Thay đổi password ");
        System.out.println("4 - Đăng xuất ");
        System.out.println("0 - Thoát chương trình ");
        int option = 0;
        try{
            option = Integer.parseInt(scanner.nextLine());
        }catch (Exception exception){
            System.out.println("Nhập dữ liệu không đúng. ");
        }
        UserHandle userHandle = new UserHandle();
        switch (option){
            case 1:
                userHandle.changeUsername(scanner,users);
                break;
            case 2:
                userHandle.changeEmail(scanner,users);
                break;
            case 3:
                userHandle.changePassword(scanner,user,users);
                break;
            case 4:
                menuLogin(scanner,users);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Nhập dữ liệu không đúng.");
                menuLoginSuccess(scanner,users,user);
                break;
        }
    }
}
