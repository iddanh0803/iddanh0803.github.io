import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập giá trị cho phần tử thứ " + (i+1) + " : ");
            array[i]= scanner.nextInt();
        }
        System.out.println("Các phần tử trong mảng: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Giá trị của phần tử thứ " + (i +1) + " = " +array[i]);
        }
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < n; i++) {
            if (max < array[i]){
                max = array[i];
            }
            if (min > array[i]){
                min = array[i];
            }
        }
        System.out.println("Số lớn nhất là: " + max);
        System.out.println("Số nhỏ nhất là: " + min);
    }
}
