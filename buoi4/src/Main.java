import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhap n");
//        int n = scanner.nextInt();
//        System.out.println("f("+n+") = " +fb(n));

    }
    public static int fb(int n){
       if(n==1 || n==0){
           return n;
       }
       return  fb((n-1)+(n-2));
    }
    public static void reverseString(char[] s){
        reverse(s,s.length-1,);
    }
    public static void reverse(char[] s, int l, int r){
        if (l >= r){
            return;
        }
        char c = s[l];
        s[l] = s[r];
        s[r] = c;

        reverse(s,l+1,r-1);
    }
}