package homework13.onlineShop.product;

import homework13.onlineShop.Storage;

public class ProductStorage extends Storage<Product> {

    Product product;

    public Product getProductByID(String id) {
        for (int i = 0; i < getSize(); i++) {
            product = getByIndex(i);
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void removeById(String id) {
        boolean found = false;
        for (int i = 0; i < getSize(); i++) {
            product = getByIndex(i);
            if (product != null && product.getId().equals(id)) {
                remove(product);
                System.out.println("Product with " + id + " has been removed");
                found = true;
            }
        }
        if (!found) System.out.println("No such Id, please try again");
    }
}
