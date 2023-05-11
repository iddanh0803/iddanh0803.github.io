package handle;

import entity.Book;
import entity.Ticket;
import entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TicketHandle {
    public Ticket createTicket(Scanner scanner, ArrayList<Ticket> tickets, Book book,User user){
        System.out.println("Ngày mượn: ");
        LocalDate loanDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Ngày trả: ");
        LocalDate payDate = LocalDate.parse(scanner.nextLine());
        return new Ticket(user,book,loanDate,payDate);
    }
}
