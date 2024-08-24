package homework4plus5;

public class Brace {

    char brace;
    int index;

    public  Brace (char brace, int index) {
        this.brace = brace;
        this.index = index;
    }

    @Override
    public String toString() {
        return  brace + " " ;
    }
}
