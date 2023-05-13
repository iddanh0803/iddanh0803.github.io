package view;

import entity.Book;
import entity.Ticket;
import entity.User;
import handle.BookHandle;
import handle.Library;
import handle.UserHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void menuLogin(Scanner scanner, ArrayList<User>users,ArrayList<Book>books,Book book,ArrayList<Ticket> tickets){
        int option = 0;
        System.out.println("1 - Đăng nhập ");
        System.out.println("2 - Đăng kí ");
        System.out.println("Mời bạn chọn: ");
        try{
            option = Integer.parseInt(scanner.nextLine());
        }catch (Exception exception){
            System.out.println("Nhập dữ liệu không đúng.");
        }
        UserHandle userHandle = new UserHandle();
        switch (option){
            case 1:
                userHandle.login(scanner,users,books,book,tickets);
                break;
            case 2:
                userHandle.createUser(scanner,users);
                System.out.println("Đăng kí thành công.");
                menuLogin(scanner,users,books,book,tickets);
                break;
            default:
                System.out.println("Nhập dữ liệu không đúng. ");
                menuLogin(scanner,users,books,book,tickets);
                break;
        }
    }
    public void menuLoginFalse(Scanner scanner, ArrayList<User> users,ArrayList<Book> books,Book book,ArrayList<Ticket> tickets){
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
                userHandle.login(scanner,users,books,book,tickets);
                break;
            case 2:
                System.out.println("Mời bạn nhập email đã đăng ký: ");
                String email = scanner.nextLine();
                User user = userHandle.findUserByEmail(users,email);
                userHandle.forgotPassword(user,scanner,users);
                break;
            default:
                System.out.println("Nhập dữ liệu không đúng.");
                menuLoginFalse(scanner,users,books,book,tickets);
                break;
        }
    }
    public void menuLoginManager(Scanner scanner, ArrayList<User> users,User user,ArrayList<Book> books,Book book,ArrayList<Ticket>tickets){
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
        MenuManage menuManage = new MenuManage();
        switch (option){
            case 1:
                menuManage.menuManageBook(scanner,users,user,books,book,tickets);
                menuLoginManager(scanner,users,user,books,book,tickets);
                break;
            case 2:
                menuManage.menuManageUser(scanner,users,user,books,book,tickets);
                menuLoginManager(scanner,users,user,books,book,tickets);
                break;
            case 3:
                menuManage.menuTicket(scanner,tickets,book,user,users,books);
                menuLoginManager(scanner,users,user,books,book,tickets);
                break;
            case 4:
                userHandle.changeEmail(scanner,users);
                userHandle.changePassword(scanner,user,users);
                userHandle.changeUsername(scanner,users);
                menuLoginManager(scanner,users,user,books,book,tickets);
                break;
            case 5:
                menuLogin(scanner,users,books,book,tickets);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Nhập dữ liệu không đúng.");
                menuLoginManager(scanner,users,user,books,book,tickets);
                break;
        }
    }
    public void menuLoginReader(Scanner scanner, ArrayList<User> users, User user, ArrayList<Book> books,Book book, ArrayList<Ticket> tickets){
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
        Library library = new Library();
        switch (option){
            case 1:
                bookHandle.findBookByName(scanner,books);
                menuLoginReader(scanner,users,user,books,book,tickets);
                break;
            case 2:
                library.borrowBook(scanner,books,book,tickets,user);
                menuLoginReader(scanner,users,user,books,book,tickets);
                break;
            case 3:

                menuLoginReader(scanner,users,user,books,book,tickets);
                break;
            case 4:
                userHandle.changeEmail(scanner,users);
                userHandle.changePassword(scanner,user,users);
                userHandle.changeUsername(scanner,users);
                menuLoginReader(scanner,users,user,books,book,tickets);
                break;
            case 5:
                menuLogin(scanner,users,books,book,tickets);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}
