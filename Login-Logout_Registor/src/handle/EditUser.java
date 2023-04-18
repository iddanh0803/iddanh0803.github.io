package handle;

import entity.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;
public class EditUser {
    public User editUsername(Scanner scanner, ArrayList<User> users, int index) {
        String usernameNew = " ";
        User userNew = null;
        do {
            System.out.println("Mời bạn nhập username muốn thay đổi: ");
            usernameNew = scanner.nextLine();

        }while (index>0);
        for (int i = 0; i < users.size(); i++) {
            User user1 = users.get(index);
            if (usernameNew == users.get(index).getUserName()){
                System.out.println("Username đã tồn tại.");
                editUsername(scanner,users,index);
            }else {
                userNew = new User(usernameNew, user1.getPassWord(), user1.geteMail());
                System.out.println("Đã cập nhật thành công.");
            }
        }
        return userNew ;
    }
    public User editEmail(Scanner scanner, ArrayList<User> users, int index){
        String emailNew = "";
        User userNew = null;
        do {
            while (true){
                System.out.println("Mời bạn nhập email muốn thay đổi: ");
                emailNew = scanner.nextLine();
                Pattern e = Pattern.compile("^[A-Za-z][0-9A-Za-z]+@[A-Za-z]{2,}(\\.[A-Za-z]+)+$");
                if (e.matcher(emailNew).find()){
                    break;
                }else {
                    System.out.println("Email không hợp lệ. Mời bạn nhập lại: ");
                }
            }
        }while (index>0);{
            for (int i = 0; i < users.size(); i++) {
                User user1 = users.get(index);
                if (Objects.equals(emailNew, users.get(i).geteMail())){
                    System.out.println("Email đã tồn tại.");
                    editEmail(scanner,users,index);
                }else {
                    userNew = new User(user1.getUserName(), user1.getPassWord(), emailNew);
                    users.remove(user1);
                    users.add(userNew);
                    System.out.println("Đã cập nhật thành công.");
                }
            }
        }
        return userNew;
    }

    public User editPassword(Scanner scanner, ArrayList<User> users, int index) {
        User userNew = null;
        String passwordNew ;
        for (int i = 0; i < users.size(); i++) {
            User user1 = users.get(index);
            while (true) {
                System.out.println("Mời bạn nhập password mới (dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa): ");
                passwordNew = scanner.nextLine();
                Pattern p = Pattern.compile("^[0-9A-Za-z]{7,15}$");
                Pattern p2 = Pattern.compile("^[0-9A-Za-z]*[A-Z]+[0-9A-Za-z]*");
                if (p.matcher(passwordNew).find() && p2.matcher(passwordNew).find()) {
                    break;
                } else {
                    System.out.println("Password không hợp lệ. Mời bạn nhập lại: ");
                }
            }
            userNew = new User(user1.getUserName(), passwordNew, user1.geteMail());
            users.remove(user1);
            users.add(userNew);
            System.out.println("Đã cập nhật thành công.");
        }
        return userNew;
    }
}

