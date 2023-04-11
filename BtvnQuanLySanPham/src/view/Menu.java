package view;

import entity.Product;

import java.util.Scanner;

public class Menu {
    public int menuSelectByPrice(Scanner scanner, Product[] products){
        System.out.println("Bann muốn tìm sản phẩm ở mức giá nào: ");
        System.out.println("1: Dưới 50.000\n" +
                "2: Từ 50.000 đến dưới 100.000\n" +
                "3: Từ 100.000 trở lên");
        System.out.println("Mời bạ chọn");
        int option = Integer.parseInt(scanner.nextLine());
        return option;
    }
}
