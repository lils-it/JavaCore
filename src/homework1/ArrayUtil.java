package homework1;

public class ArrayUtil {

    public static void main(String[] args) {


        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};

        //
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        //
        System.out.print("\nFirst Element: " + numbers[0]);
        //
        System.out.print("\nLast Element: " + numbers[numbers.length-1]);
        //
        System.out.print("\nArray Length : " + numbers.length);
        //
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min){
                min = numbers[i];
            }
        }
        System.out.println("\nMinimum number: " + min);
        //
        int middle = numbers [(numbers.length-1)/2];
        int middle2 = numbers [(numbers.length)/2];

        if (numbers.length>2) {
            if ( numbers.length %2 == 0) {
                System.out.println("Middle Elements: " + middle + "and " + middle2) ;
            }
            else  System.out.println("Middle Element: " + middle);
        } else System.out.println("Can't print middle values");
        //
        System.out.print("Even numbers: ");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + "\t");
            }
        }
        //
        System.out.print("\nOdd numbers: ");
        for (int num : numbers) {
            if (num % 2 != 0) {
                System.out.print(num + "\t");
            }
        }
        //
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("\nSummary of numbers: " + sum);
        //
        System.out.println("Average of numbers: " + sum / numbers.length);

    }
}
