package handle;
import entity.Book;
import entity.Ticket;
import entity.User;
import view.Menu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserHandle {
    //Tạo tài khản
    public void createUser(Scanner scanner, ArrayList<User> users){
        String role = "";
        System.out.println("Nhập username: ");
        String username = scanner.nextLine();

        String email = "";
        while (true){
            System.out.println("Nhập email: ");
            email = scanner.nextLine();
            Pattern e = Pattern.compile("^[A-Za-z][0-9A-Za-z]+@[A-Za-z]{2,}(\\.[A-Za-z]+)+$");
            if (e.matcher(email).find()){
                break;
            }else {
                System.out.println("Email không hợp lệ. Mời nhập lại: ");
            }
        }
        String password = "";
        while (true){
            System.out.println("Nhập password (dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa): ");
            password = scanner.nextLine();
            Pattern p = Pattern.compile("^[0-9A-Za-z]{7,15}$");
            Pattern p2 = Pattern.compile("^[0-9A-Za-z]*[A-Z]+[0-9A-Za-z]*");
            if (p.matcher(password).find() && p2.matcher(password).find()){
                break;
            }else {
                System.out.println("Password không hợp lệ. Mời nhập lại: ");
            }
        }
        boolean check = false;
        for (User user:users
             ) {
            if (user.getUsername().equalsIgnoreCase(username) || user.getEmail().equalsIgnoreCase(email)){
                check = true;
                break;
            }
        }
        if (!check){
            System.out.println("Username hoặc email đã được sử dụng. ");
            createUser(scanner,users);
        }else {
            User user = new User(username,email,password,role);
            users.add(user);
        }
    }
    Menu menu = new Menu();
    // Đăng nhập
    public void login(Scanner scanner, ArrayList<User> users, ArrayList<Book> books, Book book, ArrayList<Ticket> tickets){
        System.out.println("Mời bạn nhập Username: ");
        String username = scanner.nextLine();
        System.out.println("Mời bạn nhập Password: ");
        String password = scanner.nextLine();
        boolean check = false;
        for (User user : users
        ) {
           if (user.getUsername().equals(username)){
               check = true;
               break;
           }
        }
        if (!check){
            System.out.println("Username không đúng.");
            login(scanner,users,books,book,tickets);
        }
        for (User user:users
             ) {
            if (user.getUsername().equals(username) && !user.getPassword().equals(password)) {
                System.out.println("Mật khẩu không đúng. ");
                menu.menuLoginFalse(scanner, users, books,book,tickets);
            }
        }
        for (User user: users
             ) {
            if (user.getUsername().equals(username)  && user.getPassword().equals(password) ){
                if (user.getRole().equalsIgnoreCase("manager")){
                    System.out.println("Chào mừng " + username + " bạn có thể thực hiện cac công việc sau: ");
                    menu.menuLoginManager(scanner,users,user,books,book,tickets);
                } else if (user.getRole().equalsIgnoreCase("reader")) {
                    System.out.println("Chào mừng " + username + " bạn có thể thực hiện cac công việc sau: ");
                    menu.menuLoginReader(scanner,users,user,books,book,tickets);
                }
            }
        }
    }
    //Tìm kiếm email
    public User findEmail(ArrayList<User> users, String email){
        for (User user:users
                ) {
            if (Objects.equals(user.getEmail(), email)){
                return user;
            }
        }
        return null;
    }
    //Quên mật khẩu
    public void forgotPassword( User user,Scanner scanner,ArrayList<User> users){
        if (user == null){
            System.out.println("Tài khoản không tồn tại.");

        }else {
            changePassword(scanner,user,users);
        }
    }
    //Đổi mật khẩu
    public void changePassword(Scanner scanner, User user, ArrayList<User> users) {
        String newPassword;
        while (true) {
            System.out.println("Nhập password mới (dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa): ");
            newPassword = scanner.nextLine();
            Pattern p = Pattern.compile("^[0-9A-Za-z]{7,15}$");
            Pattern p2 = Pattern.compile("^[0-9A-Za-z]*[A-Z]+[0-9A-Za-z]*");
            if (user != null && p.matcher(newPassword).find() && p2.matcher(newPassword).find()) {
                user.setPassword(newPassword);
                System.out.println("Đổi mật khẩu thành công.");
                break;
            } else {
                System.out.println("Password không hợp lệ. Mời nhập lại: ");
            }
        }
    }
    //Tìm User theo tên
    public User findUserByUsername(Scanner scanner,ArrayList<User> users) {
        System.out.println("Mời bạn nhập username muốn tìm: ");
        String username = scanner.nextLine();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    //Đổi Username
    public void changeUsername(Scanner scanner, ArrayList<User> users) {
        for (User user : users) {
            System.out.println("Nhập username mới: ");
            String userNameNew = scanner.nextLine();
            if (findUserByUsername(scanner,users) != null) {
                System.out.println("Username đã tồn tại.");
            }else {
                user.setUsername(userNameNew);
                System.out.println("Đổi username thành công.");
            }
        }
    }
    //Tìm User theo email
    public User findUserByEmail(ArrayList<User> users, String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
    //Đổi email
    public void changeEmail(Scanner scanner, ArrayList<User> users) {
        for (User user : users) {
            String emailNew;
            while (true){
                System.out.println("Nhập email: ");
                emailNew = scanner.nextLine();
                Pattern e = Pattern.compile("^[A-Za-z][0-9A-Za-z]+@[A-Za-z]{2,}(\\.[A-Za-z]+)+$");
                if (e.matcher(emailNew).find()){
                    break;
                }else {
                    System.out.println("Email không hợp lệ. Mời nhập lại: ");
                }
            }
            if (findUserByEmail(users, emailNew) != null) {
                System.out.println("Email đã được sử dụng.");
            } else {
                user.setEmail(emailNew);
                System.out.println("Đổi email thành công.");
            }
        }
    }
}
