package homework13.onlineShop;

public interface AdminCommands {

//0 - logout
//1 - add product
//2 - remove product by id
//3 - print products
//4 - print users (միայն USER ներին)
//5 - print orders
//6 - change order status(Ստուգում եք եթե օրդերի ստատուսը դրեց DELIVERED ուրեմն պրոդուկտից էդ քանակով կհանեք )


    String LOGOUT = "0";
    String ADD_PRODUCT = "1";
    String REMOVE_PRODUCT_BY_ID = "2";
    String PRINT_PRODUCTS = "3";
    String PRINT_USERS = "4";
    String PRINT_ORDERS = "5";
    String PRINT_ORDER_STATUS = "6";
    String CHANGE_ORDER_STATUS = "7";


    String LOGOUT_COMMAND = "Please input " + LOGOUT + " to log out of the system";
    String ADD_PRODUCT_COMMAND = "Please input " + ADD_PRODUCT + " to add product";
    String REMOVE_PRODUCT_BY_ID_COMMAND = "Please input " + REMOVE_PRODUCT_BY_ID + " to remove product by id";
    String PRINT_PRODUCTS_COMMAND = "Please input " + PRINT_PRODUCTS + " to print products";
    String PRINT_USERS_COMMAND = " Please input " + PRINT_USERS + " to print users";
    String PRINT_ORDERS_COMMAND = "Please input " + PRINT_ORDERS + " to print orders";
    String PRINT_ORDER_STATUS_COMMAND = " Please input " + PRINT_ORDER_STATUS + " to print order status";
    String CHANGE_ORDER_STATUS_COMMAND = " Please input " + CHANGE_ORDER_STATUS+ " to change order status";

    static void printAdminCommands() {
        System.out.println(LOGOUT_COMMAND);
        System.out.println(ADD_PRODUCT_COMMAND);
        System.out.println(REMOVE_PRODUCT_BY_ID_COMMAND);
        System.out.println(PRINT_PRODUCTS_COMMAND);
        System.out.println(PRINT_USERS_COMMAND);
        System.out.println(PRINT_ORDERS_COMMAND);
        System.out.println(PRINT_ORDER_STATUS_COMMAND);
        System.out.println(CHANGE_ORDER_STATUS_COMMAND);
    }

}
