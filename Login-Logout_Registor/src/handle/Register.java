package handle;

import entity.User;

import java.util.Scanner;

public class Register {
    public User register(Scanner scanner){
        System.out.println("Mời bạn nhập username: ");
        String username = scanner.nextLine();
        System.out.println("Mời bạn nhập email: ");
        String email = scanner.nextLine();
        System.out.println("Mời bạn nhập password: ");
        String password = scanner.nextLine();
        return new User();
    }
}
