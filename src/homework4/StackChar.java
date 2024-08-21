package homework4;

public class StackChar {

    char[] stack =  new char[10];
    int topOfStack ;

    public StackChar() {
        topOfStack = -1;
    }

    void push (char value) {
        if (topOfStack == stack.length-1){
            System.out.println("Stack is full");
        } else stack[++topOfStack] = value;
    }
    boolean stackIsEmpty () {
        return topOfStack < 0;
    }

    char pop (){
        if (stackIsEmpty()) {
            System.out.println("Stack underflow ");
            return  ' ';
        }
         else return stack[topOfStack--];
    }

    void print() {
        if (!stackIsEmpty()) {
            System.out.println("Stack is :  ");
            for (int i = 0; i <= topOfStack; i++) {
                System.out.print(stack[i] + " ");
            }
        }
        System.out.println();
    }
}
