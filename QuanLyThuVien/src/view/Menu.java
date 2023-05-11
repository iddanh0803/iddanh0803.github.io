package view;

import entity.Book;
import entity.User;
import handle.BookHandle;
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
    public void menuLoginManager(Scanner scanner, ArrayList<User> users,User user){
        System.out.println("1 - Quản lý tài liệu ");
        System.out.println("2 - Quản lý người đọc ");
        System.out.println("3 - Quản lý mượn trả ");
        System.out.println("4 - Cập nhật thông tin cá nhân ");
        System.out.println("5 - Đăng xuất ");
        System.out.println("0 - Thoát chương trình ");
        int option = 0;
        try{
            option = Integer.parseInt(scanner.nextLine());
        }catch (Exception exception){
            System.out.println("Nhập dữ liệu không đúng. ");
        }
        UserHandle userHandle = new UserHandle();
        BookHandle bookHandle = new BookHandle();
        switch (option){
            case 1:
                userHandle.changeUsername(scanner,users);
                menuLoginManager(scanner,users,user);
                break;
            case 2:
                userHandle.changeEmail(scanner,users);
                menuLoginManager(scanner,users,user);
                break;
            case 3:
                userHandle.changePassword(scanner,user,users);
                menuLoginManager(scanner,users,user);
                break;
            case 4:
                userHandle.changeEmail(scanner,users);
                userHandle.changePassword(scanner,user,users);
                userHandle.changeUsername(scanner,users);
                menuLoginManager(scanner,users,user);
                break;
            case 5:
                menuLogin(scanner,users);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Nhập dữ liệu không đúng.");
                menuLoginManager(scanner,users,user);
                break;
        }
    }
    public void menuLoginReader(Scanner scanner, ArrayList<User> users,User user){
        System.out.println("1 - Tìm kiếm sách");
        System.out.println("2 - Mượn sách ");
        System.out.println("3 - Trả sách ");
        System.out.println("4 - Cập nhật thông tin cá nhân ");
        System.out.println("5 - Đăng xuất");
        System.out.println("0 - Thoát chương trình ");
        int option = 0;
        try {
            option = Integer.parseInt(scanner.nextLine());
        }catch (Exception exception){
            System.out.println("Nhập dữ liệu không đúng.");
        }
        BookHandle bookHandle = new BookHandle();
        UserHandle userHandle = new UserHandle();
        switch (option){
            case 1:

                menuLoginReader(scanner,users,user);
                break;
            case 2:

                menuLoginReader(scanner,users,user);
                break;
            case 3:
                menuLoginReader(scanner,users,user);
                break;
            case 4:
                userHandle.changeEmail(scanner,users);
                userHandle.changePassword(scanner,user,users);
                userHandle.changeUsername(scanner,users);
                menuLoginReader(scanner,users,user);
                break;
            case 5:
                menuLogin(scanner,users);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}
