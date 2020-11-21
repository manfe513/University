package ex_3;

class One {

    int num;

    One (int num) {
        this.num = num;
    }

    void setNum(int newNum) { num = newNum; }

    @Override
    public String toString() {
        return "One{" +
                "num=" + num +
                '}';
    }
}