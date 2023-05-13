package handle;

import entity.Book;
import entity.Ticket;
import entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public void createTicket(Scanner scanner, ArrayList<Ticket> tickets, Book book, User user) {
        LocalDate loanDate = null;
        while (true){
            System.out.println("Ngày mượn (yyyy-mm-dd): ");
            try{
                loanDate = LocalDate.parse(scanner.nextLine());
                break;
            }catch (Exception exception){
                System.out.println("Nhập dữ liệu không đúng.");
            }
        }
        LocalDate payDate = null;
        while (true){
            try {
                System.out.println("Ngày trả (yyyy-mm-dd): ");
                payDate = LocalDate.parse(scanner.nextLine());
                break;
            } catch (Exception exception) {
                System.out.println("Nhập dữ liệu không đúng.");
            }
        }
        Ticket ticket = new Ticket(user, book, loanDate, payDate);
        tickets.add(ticket);
    }

    public void borrowBook(Scanner scanner, ArrayList<Book> books, Book book, ArrayList<Ticket> tickets, User user) {
        BookHandle bookHandle = new BookHandle();
        bookHandle.findBookByName(scanner,books);
        bookHandle.findBookById(scanner,books);
        int amount = 0;
        while (true){
            System.out.println("Mời bạn nhập số lượng sách muốn mượn: ");
            try {
                amount = Integer.parseInt(scanner.nextLine());
            } catch (Exception exception) {
                System.out.println("Nhập dữ liệu không đúng. ");
            }
            if (amount > book.getAmount()) {
                System.out.println("Số lượng sách không đủ.");
                borrowBook(scanner, books, book, tickets, user);
            } else if (amount < 1) {
                System.out.println("Nhập dữ liệu không đúng.");
                borrowBook(scanner, books, book, tickets, user);
            }else {
                book.setAmount(book.getAmount()-amount);
                break;
            }
        }
        Library library = new Library();
        library.createTicket(scanner, tickets, book, user);
        System.out.println("Mượn sách thành công.");
    }

    public void returnBook(Scanner scanner,ArrayList<Ticket> tickets,Book book,User user) {
        boolean found = false;
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getBook().equals(book) && tickets.get(i).getUser().equals(user)){
                tickets.get(i).setStatus("Đã trả sách.");
                System.out.println("Đã trả sách thành công.");
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Không tìm thấy thông tin sách.");
        }
    }
}
