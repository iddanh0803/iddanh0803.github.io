package handle;

import entity.Book;
import entity.Ticket;
import entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public void createTicket(Scanner scanner, ArrayList<Ticket> tickets, Book book,User user){

        System.out.println("Ngày mượn: ");
        LocalDate loanDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Ngày trả: ");
        LocalDate payDate = LocalDate.parse(scanner.nextLine());
        Ticket ticket = new Ticket(user,book,loanDate,payDate);
        tickets.add(ticket);
    }
    public void borrowBook(Scanner scanner, ArrayList<Book> books, Book book, ArrayList<Ticket> tickets,User user) {
        System.out.println("Mời bạn nhập ID của sách muốn mượn: ");
        int id = 0;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (Exception exception) {
            System.out.println("Nhập dữ liệu không đúng.");
            borrowBook(scanner, books, book,tickets,user);
        }
        System.out.println("Mời bạn nhập số lượng sách muốn mượn: ");
        int amount = 0;
        System.out.println("Mời bạn nhập số lượng sách muốn mượn: ");
        try {
            amount = Integer.parseInt(scanner.nextLine());
        } catch (Exception exception) {
            System.out.println("Nhập dữ liệu không đúng. ");
            borrowBook(scanner, books, book,tickets,user);
        }
        if (amount > book.getAmount()) {
            System.out.println("Số lượng sách không đủ.");
            borrowBook(scanner, books, book,tickets,user);
        }
        if (amount < 1) {
            System.out.println("Nhập dữ liệu không đúng.");
            borrowBook(scanner, books, book,tickets,user);
        }
        Library ticketHandle = new Library();
        ticketHandle.createTicket(scanner,tickets,book,user);

    }
    public void returnBook(){

    }
    public void displayTicket(Ticket ticket){
        System.out.println(ticket);
    }
}
