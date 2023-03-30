import java.util.Arrays;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);

        //bai 2
        System.out.println("Nhập n: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập giá trị cho phần tử thứ "+ (i+1)+" : " );
            array[i] = sc.nextInt();
        }
        System.out.println("In mảng ra màn hình:");
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2 == 0){
                array[i]++;
            }
            System.out.println(Arrays.toString(array));
        }
    }
}