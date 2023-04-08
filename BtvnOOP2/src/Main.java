import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Điểm: ");
        double diem = Double.parseDouble(scanner.nextLine());
        System.out.println("Họ tên: ");
        String name = scanner.nextLine();
        System.out.println("Chuyền ngành: ");
        String major = scanner.nextLine();
        Diem diem1 = new Diem(diem,name,major);
        System.out.println(diem1.toString());

        System.out.println("Điểm Java: ");
        double diemJava = Double.parseDouble(scanner.nextLine());
        System.out.println("Điểm Html: ");
        double diemHtml = Double.parseDouble(scanner.nextLine());
        System.out.println("Điểm Css: ");
        double diemCss = Double.parseDouble(scanner.nextLine());
        SinhVienIT sinhVienIT = new SinhVienIT(name,major,diemJava,diemHtml,diemCss);
        System.out.println(sinhVienIT.toString());
    }
}