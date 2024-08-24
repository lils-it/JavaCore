package homework4plus5;

import java.util.Scanner;

public class BraceCheckerDemo {


    public static void main(String[] args) {

        String text = "Hello (from) [Java}" ;
        String text2 = "(())Hello Java";
        String text3 = "}[[(Hello from java)";

        BraceChecker braceChecker = new BraceChecker(text);
        braceChecker.check();
        braceChecker = new BraceChecker(text2);
        braceChecker.check();
        braceChecker = new BraceChecker(text3);
        braceChecker.check();
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        String userText = scanner.nextLine();

        BraceChecker braceCheckerUser = new BraceChecker(userText);
        braceCheckerUser.check();

        scanner.close();
    }
}
