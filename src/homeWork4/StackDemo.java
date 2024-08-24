package homeWork4;

public class StackDemo {


    public static void main(String[] args) {


        Stack stack = new Stack();

        stack.print();
        stack.push(6);
        stack.push(10);
        stack.push(20);

        stack.print();

        stack.pop();
        stack.print();


    }
}
