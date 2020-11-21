package ex_3;

class Two extends One {

    char ch;

    Two(int num, char ch) {
        super(num);
        this.ch = ch;
    }

    void setFields(int num, char ch) {
        super.setNum(num);
        this.ch = ch;
    }

    @Override
    public String toString() {
        return "Two{" +
                "num=" + num +
                ", ch=" + ch +
                '}';
    }
}