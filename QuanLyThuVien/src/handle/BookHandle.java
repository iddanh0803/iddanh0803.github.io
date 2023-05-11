package handle;

import entity.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookHandle {
    //Thêm sách
    public void addBook(Scanner scanner, ArrayList<Book> books){
        System.out.println("Mời bạn nhập tên sách: ");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập chủ đề: ");
        String subject = scanner.nextLine();
        System.out.println("Mời bạn nhập tên tác giả: ");
        String author = scanner.nextLine();
        System.out.println("Mời bạn nhập số lượng: ");
        int amount = Integer.parseInt(scanner.nextLine());
        Book book = new Book(name,subject,author,amount);
        books.add(book);
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
        if (checkName = false) {
            System.out.println("Không tìm thấy sách.");
        } else {
            books.remove(delete);
        }
    }
    //Sửa thông tin sách
    public void editBook(Scanner scanner, ArrayList<Book> books){
        System.out.println("Nhập tên sách muốn sửa: ");
        String name = scanner.nextLine();
        boolean checkName = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equalsIgnoreCase(name)){
                System.out.println("Mời bạn nhập tên muốn sửa:");
                String newName = scanner.nextLine();
                books.get(i).setName(newName);
                System.out.println("Mời bạn nhập chủ đề muốn sửa: ");
                String newSubject = scanner.nextLine();
                books.get(i).setSubject(newSubject);
                System.out.println("Mời bạn nhập tên tác giả muốn sửa: ");
                String newAuthor = scanner.nextLine();
                books.get(i).setAuthor(newAuthor);
                System.out.println("Mời bạn nhập số lượng sách muốn sửa: ");
                int newAmount = Integer.parseInt(scanner.nextLine());
                books.get(i).setAmount(newAmount);
                checkName = true;
            }
        }
        if (checkName = false) System.out.println("Không tìm thấy sách.");
    }
    public Book findBookByName(Scanner scanner,ArrayList<Book>books){
        System.out.println("Mời bạn nhập tên sách muốn tìm: ");
        String name = scanner.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equalsIgnoreCase(name)) System.out.println(books.get(i));;
        }
        return null;
    }
    public void borrowBook(Scanner scanner,ArrayList<Book>books){
        System.out.println("Mời bạn nhập tên sách muốn mượn: ");
        String name = scanner.nextLine();
        for (Book book: books
             ) {
            if (book.getName().equalsIgnoreCase(name));
        }
    }
}
