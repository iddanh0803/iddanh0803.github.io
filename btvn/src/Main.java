import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continues = " ";
        do{
            System.out.println("Input Name: ");
            String name = scanner.nextLine();
            System.out.println(name);

            System.out.println("Input Address: ");
            String address = scanner.nextLine();
            System.out.println(address);

            System.out.println("Input Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println(age);

            System.out.println("Do you want to continues? (Y/N)");

            continues = scanner.nextLine();
        }while (continues.equalsIgnoreCase("y"));


    }
}