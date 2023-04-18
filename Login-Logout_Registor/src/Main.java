import entity.User;
import handle.EditUser;
import handle.Login;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        String username = "DuyAnh";
        String password = "Duyanh123";
        String email = "duyanhnguyen832@gmail.com";
        User user = new User(username, password, email);
        users.add(user);
        Menu menu = new Menu();
        menu.showMenu(scanner,users);


    }
}