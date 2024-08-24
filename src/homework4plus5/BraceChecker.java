package homework4plus5;

public class BraceChecker {

    private final String text;

    public BraceChecker(String text) {
        this.text = text;
    }

    void print() {
        System.out.println("Text: " + text);
    }

    public void check () {

       StackChar stChar = new StackChar();

        for (int i = 0; i < text.length() ; i++) {
            char actualC = text.charAt(i);
            if (actualC == '[' || actualC == '{' || actualC == '(') {
                stChar.push(new Brace(actualC, i));
                continue;
            }
            if (actualC == ']' || actualC == '}' || actualC == ')') {
                if (stChar.stackIsEmpty()) {
                    System.out.println("Error: closed " + actualC + " at index " + i + " but nothing was opened.");
                    continue;
                }


                    Brace lastCheck;

                    switch (actualC) {
                        case ']':
                            lastCheck = stChar.pop();
                            if (lastCheck.brace != '[') {
                                System.out.println("Error: opened " + lastCheck + " but closed " + actualC + " at index " + i);
                            }
                            break;
                        case '}':
                            lastCheck = stChar.pop();
                            if (lastCheck.brace != '{') {
                                System.out.println("Error: opened " + lastCheck + " but closed " + actualC + " at index " + i);
                            }
                            break;
                        case ')':
                            lastCheck = stChar.pop();
                            if (lastCheck.brace != '(') {
                                System.out.println("Error: opened " + lastCheck + " but closed " + actualC + " at index " + i);
                            }
                            break;
                    }

            }
        }

        while (!stChar.stackIsEmpty()) {
            Brace unclosedC =  stChar.pop();
            int unclosedIndex = unclosedC.index;
            System.out.println("Error: opened " + unclosedC + " but did not close at index " + unclosedIndex );
        }
        System.out.println();
    }
}
