import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args){
        Scanner  scanner = new Scanner(System.in);
        System.out.println("Nhập họ và tên: ");
        String name = scanner.nextLine();
        String[] words = name.split(" ");
        String names = "";
        for (String w: words
             ) {
            names = names + (w.substring(0,1).toUpperCase() + w.substring(1));
            names = names + " ";
        }
        System.out.println("In ra man hinh: " + names);
    }
}
