package ex_5;

public class Three  extends One {

    protected char ch;

    Three(String text, char ch) {
        super(text);
        this.ch = ch;
    }

    void print() {
        System.out.println("class Three, text = " + text + ", ch = " + ch);
    }
}
