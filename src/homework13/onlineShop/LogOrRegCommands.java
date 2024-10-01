package homework13.onlineShop;

public interface LogOrRegCommands {

    String LOGIN = "0";
    String REGISTER = "1";
    String EXIT = "3";

    String LOGIN_COMMAND = " Please input " + LOGIN + " to login to your account.";
    String REGISTER_COMMAND = "Please input " + REGISTER + " to register a new account. ";
    String EXIT_COMMAND = "Please input " + EXIT + " to exit";

    static void printLogOrRegCommands() {
        System.out.println(LOGIN_COMMAND);
        System.out.println(REGISTER_COMMAND);
        System.out.println(EXIT_COMMAND);
    }
}
