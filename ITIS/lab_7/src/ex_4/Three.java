package ex_4;

public class Three extends Two {

    int num;

    Three(char ch, String text, int num) {
        super(ch, text);
        this.num = num;
    }

    Three(Three obj) {
        this(obj.ch, obj.text, obj.num);
    }

    @Override
    public String toString() {
        return "Three{" +
                "num=" + num +
                ", text='" + text + '\'' +
                ", ch=" + ch +
                '}';
    }
}
