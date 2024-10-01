package homework13.onlineShop.order;

import homework13.onlineShop.Storage;
import homework13.onlineShop.product.Product;
import homework13.onlineShop.user.User;
import homework13.onlineShop.user.UserStorage;

import java.util.Arrays;

public class OrderStorage extends Storage<Order> {

    Order order;
    Product product;


    public void add(Order element, User user) {
        element.setUser(user);
        super.add(element);
    }

    public void removeById(String id) {
        boolean found = false;
        for (int i = 0; i < getSize(); i++) {
            order = getByIndex(i);
            if (order != null && order.getId().equals(id)) {
                remove(order);
                System.out.println("Order with " + id + " has been removed");
                found = true;
            }
        }
        if (!found) System.out.println("No such Id, please try again");
    }


    public void printOrders(User user) {
        for (int i = 0; i < getSize(); i++) {
            order = getByIndex(i);
            if (order.getUser().equals(user)) {
                System.out.println(order);
            }
        }
    }

    public Order getById(String id) {
        for (int i = 0; i < getSize(); i++) {
            order = getByIndex(i);
            if (order != null && order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }
    public String getProductIdByOrderId(String id) {
        Order order = getById(id);
        return order.getProduct().getId();
    }
}
