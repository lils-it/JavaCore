package homework1;

public class ForIfExamples {

    public static void main(String[] args) {

        numbersOneToTen();
        sumOfNumbersOneToHundred();
        numbersFrom1To50Reverse();
        oddNumbersOnTo20();
        countEvenNumbersFrom1To100();

    }

    private static void oddNumbersOnTo20() {
        System.out.println("\n\n4. Odd numbers from 1 to 20:");
        for (int i = 1; i < 21; i++) {
            if ((i & 1) != 0) {
                System.out.print(" " + i);
            }
        }
    }

    private static void sumOfNumbersOneToHundred() {
        int summary = 0;
        for (int i = 1; i < 101; i++) {
            summary += i;
        }
        System.out.println("\n\n2. Summary of numbers from 1 to 100:\t" + summary);
    }

    private static void numbersOneToTen() {
        System.out.println("1. Numbers one to ten:");
        for (int i = 1; i < 11; i++) {
            System.out.print("\t" + i);
        }
    }

    private static void numbersFrom1To50Reverse() {
        System.out.println("\n3. Numbers from 50 to 1: ");
        for (int i = 50; i >= 1; i--) {
            System.out.print(" " + i);
        }
    }

    private static void countEvenNumbersFrom1To100() {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if ((i & 1) == 0) {
                count++;
            }
        }
        System.out.println("\n\n5. Count of even numbers from 1 to 100 is:\t\t" + count);
    }
}
