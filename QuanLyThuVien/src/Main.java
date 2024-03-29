import entity.Book;
import entity.Ticket;
import entity.User;
import handle.BookHandle;
import view.Menu;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        User user = new User("duyanh", "duyanh@gmail.com","Duyanh123","manager");
        User user1 = new User("iddanh" , "iddanh@gmail.com" ,"Iddanh123","reader");
        User user2 = new User("danh" , "Danh@gmail.com", "Danh123", "reader");
        users.add(user);
        users.add(user1);
        users.add(user2);
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("Toán", "Khoa học","Kim Đồng",3);
        Book book1 = new Book("Văn","Xã hội", "Kim Đồng", 2);
        Book book2 = new Book("Vật lý","Khoa học", "Kim Đồng",5);
        Book book3 = new Book("Anh" , "Xã hội", "Kim đồng", 6);
        books.add(book);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        ArrayList<Ticket> tickets= new ArrayList<>();
        Menu menu = new Menu();
        menu.menuLogin(scanner,users,books,book,tickets);
    }
}