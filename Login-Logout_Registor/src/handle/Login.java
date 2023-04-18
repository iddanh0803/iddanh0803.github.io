package handle;

import entity.User;
import view.Menu2;
import view.Menu3;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Login {

    public Integer login(Scanner scanner, ArrayList<User> users) {
        String username = "";
        String password = "";
        Integer index = -1;
        do {
            System.out.println("Mời bạn nhập username: ");
            username = scanner.nextLine();
            System.out.println("Mời bạn nhập password: ");
            password = scanner.nextLine();
        } while (index >= 0);
        {
            if (users.size() == 0) {
                System.out.println("Kiểm tra lại username");
            } else {
                for (int i = 0; i < users.size(); i++) {
                    if (!Objects.equals(users.get(i).getUserName(), username)) {
                        System.out.println("Kiểm tra lại username");
                        login(scanner,users);
                    } else if (!Objects.equals(users.get(i).getPassWord(), password)) {
                        Menu3 menu3 = new Menu3();
                        menu3.showMenu3(scanner,users,index);
                    } else {
                        index = i;
                        Menu2 menu2 = new Menu2();
                        menu2.showMenu2(scanner, users,index);
                    }
                }
            }
        }
        return index;
    }
}
