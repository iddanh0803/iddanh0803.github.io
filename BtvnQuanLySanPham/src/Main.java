import entity.Product;
import producthandle.ProductHandle;
import view.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số lượng các sản phẩm: ");
        int n = Integer.parseInt(scanner.nextLine());
        ProductHandle productHandle = new ProductHandle();
        Product [] products = new Product[n];
        for (int i = 0; i < n; i++) {
            Product product = productHandle.creatProduct(scanner);
            products[i] = product;
        }
        productHandle.displayProduct(products);

        System.out.println("Mời bạn nhập tên sản phẩm muốn tìm: ");
        String name = scanner.nextLine();
        productHandle.getProductByName(products,name);

        System.out.println("Mời bạn nhập vào ID của sản phầm mà bạn muốn tìm: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product =  productHandle.getProductbyId(products,id);

        System.out.println("Mời bạn nhập vào số lượng sản phẩm muốn update: ");
        int amountNew = Integer.parseInt(scanner.nextLine());
        boolean checkUpdate = productHandle.updateProductById(product, amountNew);
        if (checkUpdate){
            System.out.println("Update thành công");
        }else System.out.println("Không tìm thấy sản phẩm update");

        System.out.println("Các sản phẩm có số lượng dưới 5 là: ");
        int amount = Integer.parseInt(scanner.nextLine());
        productHandle.getProductByAmount(products);

        Menu menu = new Menu();
        int option = menu.menuSelectByPrice(scanner, products);
        productHandle.filterByPrice(products,option);

        productHandle.sortByPrice(products);
    }
}