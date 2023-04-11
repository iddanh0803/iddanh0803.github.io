package producthandle;

import entity.Product;

import java.util.Scanner;

public class ProductHandle {
    public Product creatProduct(Scanner scanner){

        System.out.println("Mời bạn nhập vào ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập vào tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Mô tả sản phẩm: ");
        String describe = scanner.nextLine();
        System.out.println("Mời bạn nhập vào số lượng sản phẩm: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập vào giá sản phẩm: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập vào đơn vị tính: ");
        String units = scanner.nextLine();
        Product product = new Product(id,name,describe,amount,price,units);
        return product;
    }
    public void displayProduct(Product[] products){
        for (Product product: products
             ) {
            System.out.println(product);
        }
    }
    public Product getProductByName(Product[] products, String name){
        for (Product product: products
             ) {
                if (product.getName().equalsIgnoreCase(name)){
                    System.out.println(product);
                }
        }
        return null;
    }
    public Product getProductbyId(Product[] products, int id){
        for (Product product: products
             ) {
                if (product.getId() == id){
                    System.out.println(product);
                }
        }
        return null;
    }
    public boolean updateProductById(Product product, int amount){
        if (product == null){
        return false;
        }else {
            product.setAmount(amount);
            return true;
        }
    }
    public Product getProductByAmount(Product [] products){
        for (Product product:products
             ) {
            if (product.getAmount()<5){
                System.out.println(product);
            }
        }
        return null;
    }
    public void filterByPrice(Product[] products, int option){
        for (Product product:products
             ) {
            if (product.getPrice()<50000 && option == 1) {
                System.out.println(product);
            }
            else if (product.getPrice()>50000 && product.getPrice()<100000 && option == 2) {
                System.out.println(product);
            } else if (product.getPrice()>=100000 && option == 3) {
                System.out.println(product);
            }
        }
    }
    public void sortByPrice(Product[]products){
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < products.length-1; j++) {
                if (products[j].getPrice() > products[j+1].getPrice()){
                    Product temp = products[j];
                    products[j] = products[j+1];
                    products[j+1] = temp;
                }
            }
        }
        System.out.println("Sản phẩm sau khi sắp xếp là:");
        for (Product product: products
             ) {
            System.out.println(product);
        }
    }
}
