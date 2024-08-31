package homework5;

public class StackChar {

    Brace[] braces = new Brace [10];
    private int topOfStack ;

    public StackChar() {
        topOfStack = -1;
    }

    boolean stackIsEmpty () {
        return topOfStack < 0;
    }

    void push (Brace brace) {
        if (topOfStack == braces.length-1){
            extend();
        }
        braces[++topOfStack] = brace;
    }

    Brace pop (){
        if (stackIsEmpty()) {
            return new Brace(' ', -1);
        }
        else return braces[topOfStack--];
    }

    private void extend() {
        Brace[] bracesNew = new Brace[braces.length + 10];
        for (int i = 0; i <= topOfStack; i++) {
            bracesNew[i] = braces[i];
        }
        braces = bracesNew;
    }
}
