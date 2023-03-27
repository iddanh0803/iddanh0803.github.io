import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên hàng nhập kho: ");
        String product = scanner.nextLine();
        System.out.println(product);

        System.out.println("Mời bạn nhập ngày tháng năm sinh");
        String date_of_birth = scanner.nextLine();
        LocalDate lcdt = LocalDate.parse(date_of_birth,DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(lcdt);

        System.out.println("Mời bạn nhập thời gian nhập hàng");
        String time_import_goods = scanner.nextLine();
        LocalDateTime Lcdt = LocalDateTime.parse(time_import_goods,DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println(Lcdt);

        System.out.println("Nhập thời gian");
        String import_time = scanner.nextLine();
        LocalTime LCdt = LocalTime.parse(import_time,DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(LCdt);

    }
}