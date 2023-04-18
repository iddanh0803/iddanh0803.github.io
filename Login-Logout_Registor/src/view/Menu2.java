package view;

import entity.User;
import handle.EditUser;
import handle.Login;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu2 {
    public void showMenu2(Scanner scanner, ArrayList<User> users,int index){
        System.out.println("Chào mừng " + users.get(index).getUserName() + ", bạn có thể thực hiện các công việc sau: ");
        System.out.println("1 - Thay đổi username ");
        System.out.println("2 - Thay đổi email ");
        System.out.println("3 - Thay đổi password ");
        System.out.println("4 - Đăng xuất ");
        System.out.println("0 - Thoát chương trình ");
        int option = 0;
        try {
            option = Integer.parseInt(scanner.nextLine());
        }catch (Exception exception){
            System.out.println("Nhập dữ liệu không đúng. ");
        }
        switch (option){
            case 1:
                EditUser editUser = new EditUser();
                editUser.editUsername(scanner,users,index);
                showMenu2(scanner,users,index);
                break;
            case 2:
                EditUser editUser1 = new EditUser();
                editUser1.editEmail(scanner,users,index);
                showMenu2(scanner,users,index);
                break;
            case 3:
                EditUser editUser2 = new EditUser();
                editUser2.editPassword(scanner,users,index);
                showMenu2(scanner,users,index);
                break;
            case 4:
                Login login = new Login();
                login.login(scanner,users);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Nhập dữ liệu không đúng. ");
                showMenu2(scanner,users,index);
        }
    }
}
