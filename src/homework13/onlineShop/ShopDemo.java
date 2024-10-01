package homework13.onlineShop;

import homework13.onlineShop.order.Order;
import homework13.onlineShop.order.OrderStatus;
import homework13.onlineShop.order.OrderStorage;
import homework13.onlineShop.order.PaymentMethod;
import homework13.onlineShop.product.Product;
import homework13.onlineShop.product.ProductStorage;
import homework13.onlineShop.user.AdminStorage;
import homework13.onlineShop.user.TypeUser;
import homework13.onlineShop.user.User;
import homework13.onlineShop.user.UserStorage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ShopDemo {

    static Scanner scanner = new Scanner(System.in);
    static User currentUser;
    static Order currentOrder;
    static UserStorage userStorage = new UserStorage();
    static AdminStorage adminStorage = new AdminStorage();
    static ProductStorage productStorage = new ProductStorage();
    static OrderStorage orderStorage = new OrderStorage();

    public static void main(String[] args) {

        userStorage.add(new User("u001", "Kirakos", "Kirakos@mail.ru", "kir001", TypeUser.USER));
        adminStorage.add(new User("a001", "Bardu", "Barduximeos@mail.ru", "bard001", TypeUser.ADMIN));
        productStorage.add(new Product("p001", "Playstation1", "Game Console", 200.0, 5, TypeShop.ELECTRONICS));

        boolean isRunning = true;

        while (isRunning) {

            LogOrRegCommands.printLogOrRegCommands();
            String command = scanner.nextLine();

            switch (command) {
                case LogOrRegCommands.LOGIN:
                    loginUser();
                    break;
                case LogOrRegCommands.REGISTER:
                    registerUser();
                    break;
                case LogOrRegCommands.EXIT:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid register command");
                    break;
            }
        }
    }

    private static void registerUser() {
        System.out.println("Please choose  ADMIN / USER");
        TypeUser typeUser = TypeUser.valueOf(scanner.nextLine());
        System.out.println("Please enter a user ID");
        String id = scanner.nextLine();
        boolean existsUser = getUserByIdExists(id);

        if (!existsUser) {
            switch (typeUser) {

                case ADMIN:
                    System.out.println("Enter your username:");
                    String name = scanner.nextLine();
                    System.out.println("Enter your password:");
                    String password = scanner.nextLine();
                    System.out.println("Enter your E-Mail:");
                    String email = scanner.nextLine();

                    if (!adminStorage.usernameAndPasswordExists(name, password)) {
                        User admin = new User(id, name, email, password, typeUser);
                        adminStorage.add(admin);
                    } else System.out.println("Password or username already exists, please try again");
                    break;

                case USER:
                    System.out.println("Enter your username:");
                    String nameUser = scanner.nextLine();
                    System.out.println("Enter your password:");
                    String passwordUser = scanner.nextLine();
                    System.out.println("Enter your E-Mail:");
                    String emailUser = scanner.nextLine();

                    if (!userStorage.usernameAndPasswordExists(nameUser, passwordUser)) {
                        User user = new User(id, nameUser, emailUser, passwordUser, typeUser);
                        userStorage.add(user);
                    } else System.out.println("Password or username already exists, please try again");
                    break;

                default:
                    System.out.println("Invalid user command");
                    break;
            }
            System.out.println("Registration successful.");
        } else {
            System.out.println("User already exists.");
        }

    }

    private static boolean getUserByIdExists(String id) {
        return userStorage.getUserByID(id) != null || adminStorage.getUserByID(id) != null;
    }

    private static void loginUser() {

        System.out.println("Enter your username:");
        String username = scanner.nextLine().trim();
        System.out.println("Enter your password:");
        String password = scanner.nextLine().trim();

        boolean existsUser = userStorage.usernameAndPasswordExists(username, password);
        boolean existsAdmin = adminStorage.usernameAndPasswordExists(username, password);

        if (existsUser) {
            currentUser = userStorage.getUserByUsername(username);
        } else if (existsAdmin) {
            currentUser = adminStorage.getUserByUsername(username);
        } else {
            System.out.println("Login failed. Incorrect username or password.");
            return;  // Exit
        }

        TypeUser typeUser = currentUser.getType();
        System.out.println("Login successful.");

        switch (typeUser) {
            case ADMIN:
                adminProcess();
                break;
            case USER:
                userProcess();
                break;
            default:
                System.out.println("Invalid User Type");

        }
    }

    private static void userProcess() {
        boolean isRunning = true;
        while (isRunning) {
            UserCommands.printUserCommands();
            String command = scanner.nextLine();
            switch (command) {
                case UserCommands.LOGOUT:
                    isRunning = false;
                    break;
                case UserCommands.PRINT_ALL_PRODUCTS:
                    if (!productStorage.isEmpty()) {
                        productStorage.printAll();
                    } else {
                        System.out.println("No products available.");
                    }
                    break;
                case UserCommands.BUY_PRODUCT:
                    System.out.println("Please give the ID of the product you want to buy: ");
                    if (!productStorage.isEmpty()) {
                        buyAProduct();
                        break;
                    } else {
                        System.out.println("No products available.");
                    }
                    break;

                case UserCommands.PRINT_MY_ORDERS:
                    if (!orderStorage.isEmpty()) {
                        orderStorage.printOrders(currentUser);
                    } else {
                        System.out.println("No orders found.");
                    }
                    break;
                case UserCommands.CANCEL_ORDER_BY_ID:
                    cancelOrderById();
                    break;
            }
        }
    }

    private static void cancelOrderById() {
        System.out.println("Please give the ID of the product you want to cancel: ");
        if (!orderStorage.isEmpty()) {
            orderStorage.printAll();
            String id = scanner.nextLine();
            orderStorage.removeById(id);
            if (currentOrder != null && currentOrder.getId().equals(id)) {
                currentOrder.setOrderStatus(OrderStatus.CANCELED);
            }
        }
    }

    private static void buyAProduct() {
        productStorage.printAll();
        String id = scanner.nextLine();
        Product product = productStorage.getProductByID(id);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        Date date = new Date();
        int qty = Integer.parseInt(getScString("quantity"));
        if (qty > product.getStockQty()) {
            System.out.println("Please enter a lower quantity.");
            return;
        }
        System.out.println("Please choose the payment method / CARD, CASH, PAYPAL");
        PaymentMethod payMethod = PaymentMethod.valueOf(scanner.nextLine().toUpperCase());
        double price = product.getPrice() * qty;
        System.out.println("Product chose: " + product.getName() + "\nOrder's total price: " + price);
        System.out.println("Do you want to buy the placed order ? / YES , NO ");
        String yesOrNo = scanner.nextLine();
        if (yesOrNo.equalsIgnoreCase("YES")){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH.mmss"); // Date format: year, month, day, hour, minute, second
            String formatDate = dateFormat.format(date);
            currentOrder = new Order(id.concat("."+formatDate), currentUser, product, date, price, OrderStatus.NEW, qty, payMethod);
            orderStorage.add(currentOrder);
            System.out.println("Processing successful! You bought the product!\n");
            product.setStockQty(product.getStockQty() - qty); // stock update after buying product
        } else {
            System.out.println("Order canceled! Please try to buy products again");
        }
    }

    private static void adminProcess() {
        boolean isRunning = true;
        while (isRunning) {
            AdminCommands.printAdminCommands();
            String command = scanner.nextLine();
            switch (command) {
                case AdminCommands.LOGOUT:
                    isRunning = false;
                    break;
                case AdminCommands.ADD_PRODUCT:
                    addProduct();
                    break;
                case AdminCommands.REMOVE_PRODUCT_BY_ID:
                    System.out.println("Please give the ID of the product you want to remove: ");
                    if (!productStorage.isEmpty()) {
                        productStorage.printAll();
                        String id = scanner.nextLine();
                        productStorage.removeById(id);
                    } else {
                        System.out.println("No products available.");
                    }
                    break;
                case AdminCommands.PRINT_PRODUCTS:
                    if (!productStorage.isEmpty()) {
                        productStorage.printAll();
                    } else {
                        System.out.println("No products available.");
                    }
                    break;
                case AdminCommands.PRINT_USERS:
                    if (!userStorage.isEmpty()) {
                        userStorage.printAll();
                    } else {
                        System.out.println("No users found.");
                    }
                    break;
                case AdminCommands.PRINT_ORDERS:
                    if (!orderStorage.isEmpty()) {
                        orderStorage.printAll();
                    } else {
                        System.out.println("No orders found.");
                    }
                    break;
                case AdminCommands.PRINT_ORDER_STATUS:
                    orderStorage.printAll();
                    System.out.println("Please give the ID of the order you want to check the status for: ");
                    String orderId = scanner.nextLine();
                    Order order = orderStorage.getById(orderId);
                    if (order != null) {
                        System.out.println("Current order status: " + order.getOrderStatus());
                    } else System.out.println("No order with this id " + orderId+ " was found!" );
                    break;
                case AdminCommands.CHANGE_ORDER_STATUS:
                    orderStorage.printAll();
                    System.out.println("Please give the ID of the order you want to change status ");
                    String orderId2 = scanner.nextLine();
                    Order order2 = orderStorage.getById(orderId2);
                    Product product2 = productStorage.getProductByID(orderStorage.getProductIdByOrderId(orderId2));
                    changeOrderStatus(order2, orderId2);

                    if (order2.getOrderStatus().equals(OrderStatus.CANCELED) && product2 != null) {
                        product2.setStockQty(product2.getStockQty() + order2.getQty());
                        orderStorage.remove(order2);
                        System.out.println("Order canceled and removed from the storage.");
                    }
                    break;
            }
        }
    }

    private static void changeOrderStatus(Order order, String orderId) {
        if (order != null) {
            System.out.println("Current order status: " + order.getOrderStatus());
            System.out.println("Change order status? YES / NO ");
            String answer = scanner.nextLine().toUpperCase();
            if (answer.equals("YES")) {
                System.out.println("Please choose the order status: / NEW, SEND , DELIVERED, CANCELED");
                OrderStatus orderStatus = OrderStatus.valueOf(scanner.nextLine().toUpperCase());
                order.setOrderStatus(orderStatus);
                System.out.println("Order status changed successfully! ");
                System.out.println("New order status: " + order.getOrderStatus());
            } else System.out.println("Order status remained.");
        } else {
            System.out.println("No order found with ID: " + orderId);
        }
    }

    private static void addProduct() {
        System.out.println("Please select the shop you want to add product: / ELECTRONICS, CLOTHING, BOOKS");
        TypeShop typeShop = TypeShop.valueOf(scanner.nextLine().toUpperCase());
        String id = getScString("id");
        String name = getScString("name");
        String description = getScString("description");
        Double price = Double.parseDouble(getScString("price"));
        int stockQty = Integer.parseInt(getScString("stock quantity"));

        Product product = new Product(id, name, description, price, stockQty, typeShop);
        productStorage.add(product);
    }

    private static String getScString(String str) {
        System.out.println("Please enter product " + str);
        return scanner.nextLine();
    }
}
