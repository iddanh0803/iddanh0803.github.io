package entity;

public class Book {
    private static int autoId;
    private int id;
    private String name;
    private String subject;
    private String author;
    private int amount;


    public Book(String name, String subject, String author, int amount) {
        this.id = ++autoId;
        this.name = name;
        this.subject = subject;
        this.author = author;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", author='" + author + '\'' +
                ", amount=" + amount +
                '}';
    }
}
