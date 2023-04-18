package handle;

import entity.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ForgotPassword {
    public void forgotPassword(Scanner scanner, ArrayList<User> users, int index) {
        String email;
        String passwordNew;
        do {
            while (true) {
                System.out.println("Mời bạn nhập email: ");
                email = scanner.nextLine();
                Pattern e = Pattern.compile("^[A-Za-z][0-9A-Za-z]+@[A-Za-z]{2,}(\\.[A-Za-z]+)+$");
                if (e.matcher(email).find()) {
                    break;
                } else {
                    System.out.println("Email không hợp lệ. Mời bạn nhập lại: ");
                }
            }
        } while (index > 0);
        {
            for (int i = 0; i < users.size(); i++) {
                if (!Objects.equals(email, users.get(i).geteMail())) {
                    System.out.println("Chưa tồn tại tài khoản. Mời bạn nhập lại.");
                    forgotPassword(scanner, users, index);
                } else{
                    while (true) {
                        System.out.println("Mời bạn nhập password mới (dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa): ");
                        passwordNew = scanner.nextLine();
                        Pattern p = Pattern.compile("^[0-9A-Za-z]{7,15}$");
                        Pattern p2 = Pattern.compile("^[0-9A-Za-z]*[A-Z]+[0-9A-Za-z]*");
                        if (p.matcher(passwordNew).find() && p2.matcher(passwordNew).find()) {
                            System.out.println("Mời bạn đăng nhập lại: ");
                            Login login = new Login();
                            login.login(scanner, users);
                            break;
                        } else {
                            System.out.println("Password không hợp lệ. Mời bạn nhập lại: ");
                        }

                    }
                }
            }
        }
    }
}