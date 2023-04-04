package Bai1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Mời bạn nhập độ dài cạnh = ");
        float n = scanner.nextFloat();
      Square square=new Square();
      float dt = square.Ssquare(n);
      float cv = square.Csquare(n);
        System.out.println("Dt hình vuông là: " + dt);
        System.out.println("Cv hình vuông là: " + cv);
        System.out.println("Độ dài cạnh hình vuông là: " + n);

        System.out.println("Mời bạ nhập chiều dài = ");
        float a = scanner.nextFloat();
        System.out.println("Mời bạn nhập chiều rộng = ");
        float b = scanner.nextFloat();
        Rectangle rectangle = new Rectangle();
        float dt2 = rectangle.Srectangle(a,b);
        float cv2 = rectangle.Crectangle(a,b);
        System.out.println("Dt hình chữ nhật là: " + dt2);
        System.out.println("Cv hình chữ nhật là: " + cv2);
        System.out.println("Chiều dài là: " + a + " Chiều rộng là: " + b);
    }
}