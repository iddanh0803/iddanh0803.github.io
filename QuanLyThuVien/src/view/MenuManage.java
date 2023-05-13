package view;

import entity.Book;
import entity.Ticket;
import entity.User;
import handle.BookHandle;
import handle.Library;
import handle.UserHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManage {
    public void menuManageBook(Scanner scanner, ArrayList<User> users, User user, ArrayList<Book> books, Book book, ArrayList<Ticket>tickets) {
        int option = 0;
        do {
            System.out.println("1 - Thêm sách. ");
            System.out.println("2 - Sửa sách.");
            System.out.println("3 - Tìm sách. ");
            System.out.println("4 - Xóa sách. ");
            System.out.println("5 - Quay lại.");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception exception) {
                System.out.println("Nhập dữ liệu không đúng.");
            }
            Menu menu = new Menu();
            BookHandle bookHandle = new BookHandle();
            switch (option){
                case 1:
                    bookHandle.addBook(scanner,books);
                    menuManageBook(scanner,users,user,books,book,tickets);
                    break;
                case 2:
                    bookHandle.editBook(scanner,books);
                    menuManageBook(scanner,users,user,books,book,tickets);
                    break;
                case 3:
                    bookHandle.findBookByName(scanner,books);
                    menuManageBook(scanner,users,user,books,book,tickets);
                    break;
                case 4:
                    bookHandle.removeBook(scanner,books);
                    menuManageBook(scanner,users,user,books,book,tickets);
                    break;
                case 5:
                    menu.menuLoginManager(scanner,users,user,books,book,tickets);
                    break;
                default:
                    System.out.println("Nhập dữ liệu không đúng.");
                    menuManageBook(scanner,users,user,books,book,tickets);
                    break;
            }
            if (option < 0 || option > 5) System.out.println("Nhập dữ liệu không đúng.");
        }while (option < 0 || option > 5);
    }
    public void menuManageUser(Scanner scanner, ArrayList<User> users, User user, ArrayList<Book> books, Book book, ArrayList<Ticket>tickets){
        int option = 0;
        do {
            System.out.println("1 - Thêm user ");
            System.out.println("2 - Sửa đổi thông tin user.");
            System.out.println("3 - Tìm user. ");
            System.out.println("4 - Xóa user. ");
            System.out.println("5 - Quay lại.");
            try{
                option = Integer.parseInt(scanner.nextLine());
            }catch (Exception exception){
                System.out.println("Nhập dữ liệu không đúng.");
            }
            Menu menu = new Menu();
            UserHandle userHandle = new UserHandle();
            switch (option){
                case 1:
                    userHandle.createUser(scanner,users);
                    menuManageUser(scanner,users,user,books,book,tickets);
                    break;
                case 2:
                    userHandle.editUser(scanner,users,user);
                    menuManageUser(scanner,users,user,books,book,tickets);
                    break;
                case 3:
                    userHandle.findUserByUsername(scanner,users);
                    menuManageUser(scanner,users,user,books,book,tickets);
                    break;
                case 4:
                    userHandle.removeUser(scanner,users);
                    menuManageUser(scanner,users,user,books,book,tickets);
                    break;
                case 5:
                    menu.menuLoginManager(scanner,users,user,books,book,tickets);
                    break;
                default:
                    System.out.println("Nhập dữ liệu không đúng.");
                    menuManageUser(scanner,users,user,books,book,tickets);
                    break;

            }
            if (option < 0 || option > 5) System.out.println("Nhập dữ liệu không đúng.");
        }while (option < 0 || option > 5);
    }
    public void menuTicket(Scanner scanner,ArrayList<Ticket>tickets,Book book,User user,ArrayList<User>users,ArrayList<Book>books){
        int option = 0;
        do {
            System.out.println("1 - Hiện thị danh sách phiếu mượn. ");
            System.out.println("2 - Tạo phiếu mượn.");
            System.out.println("3 - Quay lại.");
            try{
                option = Integer.parseInt(scanner.nextLine());
            }catch (Exception exception){
                System.out.println("Nhập dữ liệu không đúng.");
            }
            Library library = new Library();
            Menu menu = new Menu();
            switch (option){
                case 1:
                    System.out.println(tickets);
                    break;
                case 2:
                    library.createTicket(scanner,tickets,book,user);
                    break;
                case 3:
                    menu.menuLoginManager(scanner,users,user,books,book,tickets);
                    break;
                default:
                    System.out.println("Nhập dữ liệu không đúng.");
                    menuTicket(scanner,tickets,book,user,users,books);
                    break;
            }
            if (option < 0 || option > 3) System.out.println("Nhập dữ liệu không đúng.");
        }while (option < 0 || option > 3);
    }
}
