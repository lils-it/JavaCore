package homework4plus5;

public class StackChar {

    char[] stack =  new char[10];
    private int[] indexStack = new int[10];
    private int topOfStack ;

    public StackChar() {
        topOfStack = -1;
    }

    boolean stackIsEmpty () {
        return topOfStack < 0;
    }

    void push (Brace brace) {
        if (topOfStack == stack.length-1){
            extend();
        }
        stack[++topOfStack] = brace.brace;
        indexStack[topOfStack] = brace.index;
    }

    Brace pop (){
        if (stackIsEmpty()) {
            return new Brace(' ', -1);
        }
        else return new Brace(stack[topOfStack], indexStack[topOfStack--]);
    }

    private void extend() {
        char[] stackNew = new char[stack.length + 10];
        int[] indexStackNew = new int[indexStack.length + 10];
        for (int i = 0; i <= topOfStack; i++) {
            stackNew[i] = stack[i];
            indexStackNew[i] = indexStack[i];
        }
        stack= stackNew;
        indexStack = indexStackNew;
    }
}
