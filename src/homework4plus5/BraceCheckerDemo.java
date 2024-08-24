package homework4plus5;

import java.util.Scanner;

public class BraceCheckerDemo {


    public static void main(String[] args) {


        String text = "Hello (from) [Java}" ;
        String text2 = "(())Hello Java";
        String text3 = "}[[(Hello from java)";

        BraceChecker braceChecker = new BraceChecker(text);
        braceChecker.print();
        braceChecker.check();
        BraceChecker braceChecker2 = new BraceChecker(text2);
        braceChecker2.print();
        braceChecker2.check();
        BraceChecker braceChecker3 = new BraceChecker(text3);
        braceChecker3.print();
        braceChecker3.check();
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        String userText = scanner.nextLine();
        BraceChecker braceCheckerUser = new BraceChecker(userText);
        braceCheckerUser.print();
        braceCheckerUser.check();

    }
}
