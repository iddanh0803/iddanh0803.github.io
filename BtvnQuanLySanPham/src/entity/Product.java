package entity;

public class Product {
    private static  int autoId;
    private int id;
    private String name;
    private String describe;
    private int amount;
    private int price;
    private String units;

    public Product(int id, String name, String describe, int amount, int price, String units) {
        this.id = ++autoId;
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.amount = amount;
        this.price = price;
        this.units = units;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
