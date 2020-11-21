package ex_3;

class Three extends Two {

    String text;

    Three(int num, char ch, String text) {
        super(num, ch);
        this.text = text;
    }

    void setFields(int num, char ch, String text) {
        super.setFields(num, ch);
        this.text = text;
    }

    @Override
    public String toString() {
        return "Three{" +
                "num=" + num +
                ", ch=" + ch +
                ", text='" + text + '\'' +
                '}';
    }
}