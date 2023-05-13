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
        User user1 = new User("linh" , "Linh@gmail.com" ,"Linh123","reader");
        users.add(user);
        users.add(user1);
        ArrayList<Book> books = new ArrayList<>();

        Book book = new Book("Toán", "Khoa học","math",3);
        Book book1 = new Book("Văn","Xã hội", "Literature", 2);
        books.add(book);
        books.add(book1);
        ArrayList<Ticket> tickets= new ArrayList<>();
        Menu menu = new Menu();
        menu.menuLogin(scanner,users,books,book,tickets);
    }
}