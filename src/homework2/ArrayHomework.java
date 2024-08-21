package homework2;

import java.util.Arrays;

public class ArrayHomework {

    public static void main(String[] args) {


        int[] numbers = {1, 6, 3, 9, 5, 52, 6, 25, 18 , 5};
        int[] numbers2;
        int ammount = 0 ;

        // 1
        int n = 6;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == n) {
                ammount ++;
            }
        }
        System.out.println(ammount);

        //2

        numbers2 = Arrays.copyOf(numbers, numbers.length);
        int tempI;
        int sizeI = numbers2.length -1;


        for (int i = 0; i < numbers2.length/2; i++) {
            tempI = numbers2[i];
            numbers2[i] = numbers2[sizeI];
            numbers2[sizeI--] = tempI;
        }
        for (int number : numbers2) {
            System.out.print(number + "  ");
        }

        System.out.println();
        //3
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
        ammount = 0;
        int size = numbers.length;

        System.out.println();
        for (int i = 0; i < size - 1 ; i++) {
            for (int j = i + 1; j < size ; j++) {
                if ( numbers[j] == numbers[i]) {
                    ammount++;
                    System.out.println("Repeats : " + numbers[j]);
                    break;
                }
            }
        }
        System.out.println("Numbers repeat times: " + ammount);

        //4

    }
}
