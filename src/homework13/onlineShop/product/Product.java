package homework13.onlineShop.product;

import homework13.onlineShop.TypeShop;

import java.util.Objects;

public class Product {

    String id;
    String name;
    String description;
    Double price;
    int stockQty;
    TypeShop typeShop;

    public Product(String id, String name, String description, Double price, int stockQty, TypeShop typeShop) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQty = stockQty;
        this.typeShop = typeShop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public TypeShop getType() {
        return typeShop;
    }

    public void setType(TypeShop typeShop) {
        this.typeShop = typeShop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return stockQty == product.stockQty && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && typeShop == product.typeShop;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, stockQty, typeShop);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQty=" + stockQty +
                ", type=" + typeShop +
                '}';
    }
}
