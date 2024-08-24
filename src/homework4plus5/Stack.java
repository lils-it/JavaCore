package homework4plus5;

public class Stack {

    int[] stack =  new int[10];
    int topOfStack ;

    public Stack () {
        topOfStack = -1;
    }

    void push (int value) {
        if (topOfStack == stack.length-1){
            System.out.println("Stack is full");
        } else stack[++topOfStack] = value;
    }

    int pop (){
        if (topOfStack < 0) {
            System.out.println(" Stack underflow");
            return -1;
        } else return stack[topOfStack--];
    }

    void print() {
        System.out.println("Stack is :  ");
        for (int i = 0; i <= topOfStack; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
