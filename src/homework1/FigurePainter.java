package homework1;

public class FigurePainter {

    public static void main(String[] args) {

    //1
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
    //2
        for (int i = 5; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();

     //3
        for (int i = 5; i >0 ; i--) {
            for (int j = 0; j <i-1; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= (5-i); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
     //4
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= (5-i); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        //5
        for (int i = 5; i >0 ; i--) {
            for (int j = 0; j <i-1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= (5-i); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 4; i >0 ; i--) {
            for (int j = 0; j <i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <(4-i); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }





    }

}
