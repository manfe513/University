package ex_4;

public class Two extends One {

    String text;

    Two(char ch, String text) {
        super(ch);
        this.text = text;
    }

    Two(Two obj) {
        this(obj.ch, obj.text);
    }

    @Override
    public String toString() {
        return "Two{" +
                "text='" + text + '\'' +
                ", ch=" + ch +
                '}';
    }
}
