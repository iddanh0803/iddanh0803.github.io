package handle;

import entity.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Register {
    public void inputRegister(Scanner scanner, ArrayList<User> users){
        System.out.println("Nhập username muốn đăng kí: ");
        String userName = scanner.nextLine();
        String email;
        while (true){
            System.out.println("Nhập email muốn đăng kí: ");
            email = scanner.nextLine();
            Pattern e = Pattern.compile("^[A-Za-z][0-9A-Za-z]+@[A-Za-z]{2,}(\\.[A-Za-z]+)+$");
            if (e.matcher(email).find()){
                break;
            }else {
                System.out.println("Email không hợp lệ. Mời bạn nhập lại: ");
            }
        }
        String password;
        while (true){
            System.out.println("Nhập password (dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa): ");
            password = scanner.nextLine();
            Pattern p = Pattern.compile("^[0-9A-Za-z]{7,15}$");
            Pattern p2 = Pattern.compile("^[0-9A-Za-z]*[A-Z]+[0-9A-Za-z]*");
            if (p.matcher(password).find() && p2.matcher(password).find()){
                break;
            }else {
                System.out.println("Password không hợp lệ. Mời bạn nhập lại: ");
            }
        }
        boolean check = false;
        for (User user : users) {
            if (user.getUserName().equals(userName) || user.geteMail().equals(email)) {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Username hoặc email đã sử dụng mời bạn nhập lại: ");
            inputRegister(scanner,users);
        }else {
            User user = new User(userName,email,password);
            users.add(user);
        }
        System.out.println("--Login--");
        Login login = new Login();
        login.login(scanner,users);
    }
}
