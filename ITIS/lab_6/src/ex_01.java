import java.util.Arrays;

/**
 * 1. Напишите программу с классом, в котором есть два ноля: символьное и текстовое.
 *
 * 1) В классе должен быть перегруженный метод для присваивания значений нолям.
 *
 * 2) Если метод вызывается с символьным аргументом, то соответствующее значение присваивается
 * символьному полю.
 *
 * 3) Если метод вызывается с текстовым аргументом, то он определяет значение текстового ноля.
 *
 * 4) Методу аргументом также может передаваться символьный массив.
 * 4.1) Если массив состоит из одного элемента, то он определяет значение символьного поля.
 * 4.2) В противном случае (если в массиве больше одного элемента) из символов массива
 * формируется текстовая строка и присваивается значением текстовому полю.
 */
public class ex_01 {

    public static void main(String[] args) {

        Sample_01 s = new Sample_01();
        s.print();

        s.set('F');
        s.set("new string value");
        s.print();

        char[] chars = {'N'};
        s.set(chars);
        s.print();

        chars = new char[]{'H', 'e', 'l', 'l', '0'};
        s.set(chars);
        s.print();
    }
}

class Sample_01 {

    private char ch;
    private String str;

    void set(char ch) {
        this.ch = ch;
    }

    void set(char[] chars) {

        if(chars.length == 1) {
            ch = chars[0];

        } else {
            str = Arrays.toString(chars);
        }
    }

    void set(String str) {
        this.str = str;
    }

    void print() {
        System.out.println("ch = " + ch + ", str = " + str);
    }
}
