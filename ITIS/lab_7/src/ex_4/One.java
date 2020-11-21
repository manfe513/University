package ex_4;

public class One {

    char ch;

    One(char ch) {
        this.ch = ch;
    }

    One(One obj) {
        this(obj.ch);
    }

    @Override
    public String toString() {
        return "One{" +
                "ch=" + ch +
                '}';
    }
}
