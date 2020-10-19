/**
 * 1. Напишите программу с классом, в котором есть закрытое символьное поле
 * и три открытых метода.
 *
 * > Один из методов позволяет присвоить значение полю.
 * > Еще один метод при вызове возвращает результатом код символа.
 * > Третий метод позволяет вывести в консольное окно символ (значение поля) и его код.
 */

public class ex_01 {

    public static void main(String[] args) {

        Sample_01 sample = new Sample_01();
        sample.printChar();

        sample.setChar('F');
        System.out.println("Char code = " + sample.getCharCode());

        sample.printChar();
    }
}

class Sample_01 {

    private char ch;

    void setChar(char newChar) {
        ch = newChar;
    }

    int getCharCode() {
        return ch;
    }

    void printChar() {
        int charCode = (int) ch;

        System.out.println("Char value: " + ch + ", char code: " + charCode);
    }
}


