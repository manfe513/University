package ex_5;

public class Two extends One{

    protected int num;

    Two(String text, int num) {
        super(text);
        this.num = num;
    }

    void print() {
        System.out.println("class Two, text = " + text + ", num = " + num);
    }
}
