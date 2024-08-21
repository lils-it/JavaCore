package homework4;

public class BraceChecker {

    private String text;

    public BraceChecker(String text) {
        this.text = text;
    }

    public void check () {

       StackChar stChar = new StackChar();

        for (int i = 0; i < text.length() ; i++) {
            char actualC = text.charAt(i);
            if (actualC == '[' || actualC == '{' || actualC == '(') {
                stChar.push(actualC);
                continue;
            }
            if (!stChar.stackIsEmpty()) {
                char lastCheck;

                switch (actualC){
                    case ']':
                        lastCheck = stChar.pop();
                        if (lastCheck != '[') {
                            System.out.println("Error: opened " + lastCheck + " but closed " + actualC + " at index " + i);
                        }
                        break;
                    case '}':
                        lastCheck = stChar.pop();
                        if (lastCheck != '{') {
                            System.out.println("Error: opened " + lastCheck + " but closed " + actualC + " at index " + i);
                        }
                        break;
                    case ')':
                        lastCheck = stChar.pop();
                        if (lastCheck != '(') {
                            System.out.println("Error: opened " + lastCheck + " but closed " + actualC + " at index " + i);
                        }
                        break;
                }
            }
        }
    }
}
