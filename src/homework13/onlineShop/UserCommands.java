package homework13.onlineShop;

public interface UserCommands {

// 0 - logout
// 1 - print all products
// 2 - buy product (կվերցնենք product-ի id-ն,  քանակը, ու վճարման տարբերակը։ կհաշվենք գինը, ու կտպենք, դուք ցանկանում եք գնել էս պրոդուկտը էս քանակով, ու էս գնով, գրեք yes եթե ցանկանում եք հաստատել, եթե գրեց, Order ի օբյեկտ կսարքենք NEW ստատուսով ու կպահենք ) Պետք է ստուգել արդյոք ներմուծված  քանակը  կա պահեստում, եթե չլինի քցեք OutOfStockException, որը մեյն կլասսում կմշակեք։
// 3 - print my orders
// 4 - cancel order by id


    String LOGOUT = "0";
    String PRINT_ALL_PRODUCTS = "1";
    String BUY_PRODUCT = "2";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";


    String LOGOUT_COMMAND = "Please input " + LOGOUT + " to log out of the system";
    String PRINT_ALL_PRODUCTS_COMMAND = "Please input " + PRINT_ALL_PRODUCTS + " to print all products";
    String BUY_PRODUCT_COMMAND = "Please input " + BUY_PRODUCT + " to buy a product";
    String PRINT_MY_ORDERS_COMMAND = "Please input " + PRINT_MY_ORDERS + " to print your orders";
    String CANCEL_ORDER_BY_ID_COMMAND = " Please input " + CANCEL_ORDER_BY_ID + " to cancel an order by id";

    static void printUserCommands() {
        System.out.println(LOGOUT_COMMAND);
        System.out.println(PRINT_ALL_PRODUCTS_COMMAND);
        System.out.println(BUY_PRODUCT_COMMAND);
        System.out.println(PRINT_MY_ORDERS_COMMAND);
        System.out.println(CANCEL_ORDER_BY_ID_COMMAND);
    }
}
