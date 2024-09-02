package homework6;

import java.util.Objects;

public class Book {

    private String title;
    private String id;
    private String authorName;
    private double price;

    private int quantity;



    public Book(String title, String id, String authorName, double price, int quantity) {
        this.title = title;
        this.id = id;
        this.authorName = authorName;
        this.price = price;
        this.quantity = quantity;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(price, book.price) == 0 && quantity == book.quantity && Objects.equals(title, book.title) && Objects.equals(id, book.id) && Objects.equals(authorName, book.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, id, authorName, price, quantity);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
