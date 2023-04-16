package handle;

import entity.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public User login(Scanner scanner){
        System.out.println("Mời bạn nhập username: ");
        String username = scanner.nextLine();
        System.out.println("Mời bạn nhập password: ");
        String password = scanner.nextLine();
        User user = new User();
        return user;
    }
    public User checkUsername(Scanner scanner, ArrayList<User> users){
        System.out.println("Mời bạn nhập username: ");
        String guessUser = scanner.nextLine();
        for (User user: users
             ) {
         if (guessUser != user.getUserName() ) {
             System.out.println("Kiểm tra lại username");
             String 
         }
        }
        return null;
    }
}
