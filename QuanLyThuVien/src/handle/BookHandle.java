package handle;

import entity.Book;
import entity.Ticket;
import entity.User;

import java.util.ArrayList;
import java.util.Scanner;

public class BookHandle {
    //Thêm sách
    public void addBook(Scanner scanner, ArrayList<Book> books) {

        System.out.println("Mời bạn nhập tên sách: ");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập chủ đề: ");
        String subject = scanner.nextLine();
        System.out.println("Mời bạn nhập tên tác giả: ");
        String author = scanner.nextLine();
        System.out.println("Mời bạn nhập số lượng: ");
        int amount = Integer.parseInt(scanner.nextLine());
        boolean checkBook = false;
        for (Book b : books
        ) {
            if (b.getName().equalsIgnoreCase(name) && b.getAuthor().equalsIgnoreCase(author)) {
                b.setAmount(b.getAmount()+amount);
                checkBook = true;
                System.out.println("Thêm sách thành công.");
                break;
            }
        }if (!checkBook){
            Book book = new Book(name, subject, author, amount);
            books.add(book);
            System.out.println("Thêm sách thành công.");
        }
    }

    //Xóa sách
    public void removeBook(Scanner scanner, ArrayList<Book> books) {
        System.out.println("Mời bạn nhập tên sách muốn xóa: ");
        String name = scanner.nextLine();
        boolean checkName = false;
        int delete = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equalsIgnoreCase(name)) {
                checkName = true;
                delete = i;
                break;
            }
        }
        if (!checkName) {
            System.out.println("Không tìm thấy sách.");
        } else {
            books.remove(delete);
            System.out.println(books);
        }
    }

    //Sửa thông tin sách
    public void editBook(Scanner scanner, ArrayList<Book> books) {
        System.out.println("Nhập tên sách muốn sửa: ");
        String name = scanner.nextLine();
        boolean checkName = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equalsIgnoreCase(name)) {
                System.out.println("Mời bạn nhập tên muốn sửa:");
                String newName = scanner.nextLine();
                books.get(i).setName(newName);
                System.out.println("Cập nhật thành công.");
                System.out.println("Mời bạn nhập chủ đề muốn sửa: ");
                String newSubject = scanner.nextLine();
                books.get(i).setSubject(newSubject);
                System.out.println("Cập nhật thành công.");
                System.out.println("Mời bạn nhập tên tác giả muốn sửa: ");
                String newAuthor = scanner.nextLine();
                books.get(i).setAuthor(newAuthor);
                System.out.println("Cập nhật thành công.");
                System.out.println("Mời bạn nhập số lượng sách muốn sửa: ");
                int newAmount = Integer.parseInt(scanner.nextLine());
                books.get(i).setAmount(newAmount);
                System.out.println("Cập nhật thành công.");
                checkName = true;
            }
        }
        if (!checkName) System.out.println("Không tìm thấy sách.");
    }

    public Book findBookByName(Scanner scanner, ArrayList<Book> books) {
        System.out.println("Mời bạn nhập tên sách muốn tìm: ");
        String name = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equalsIgnoreCase(name)) {
                System.out.println(books.get(i));
                check = true;

            }
        }
        if (!check) System.out.println("Không tìm thấy sách.");
        return null;
    }
    public Book findBookById(Scanner scanner, ArrayList<Book> books){
        int id = 0;
        System.out.println("Mời bạn nhập Id sách muôn tìm: ");
        while (true){
            try{
                id = Integer.parseInt(scanner.nextLine());
                break;
            }catch (Exception exception){
                System.out.println("Nhập dữ liệu không đúng.");
            }
        }
        boolean check = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId()==id){
                check = true;
                System.out.println(books.get(i));
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy sách.");
            findBookById(scanner,books);
        }
        return null;
    }
}
