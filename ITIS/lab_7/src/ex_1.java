/**
 * 1. Напишите программу, в которой есть суперкласс с приватным текстовым полем,
 * конструктором с текстовым параметром и где переопределен метод toString (). На основе
 * суперкласса путем наследования создается подкласс. У него появляется еще одно
 * приватное текстовое ноле. Также подкласс должен иметь версии конструктора с одним и
 * двумя текстовыми аргументами, а еще в нем должен быть переопределен метод toString ().
 * В обоих классах метод toString () переопределяется так, что он возвращает строку с
 * названием класса и значение текстового поля или текстовых полей.
 */

public class ex_1 {

    public static void main(String[] args) {

        Sub_1 subCls = new Sub_1("subslass text");

        //superText = null
        //sbText = "subslass text"
        System.out.println(subCls.toString());

        //просто отделить вывод
        System.out.println();

        Sub_1 subCls_2 = new Sub_1("super text 1", "subslass text");

        //superText = "super text 1"
        //sbText = "subslass text"
        System.out.println(subCls_2.toString());
    }
}

class Super_1 {

    private String superText;

    Super_1() {
        //значение текста = значение по умолчанию для экземпляров класса,
        // для строки = null
    }

    Super_1(String superText) {
        this.superText = superText;
    }

    @Override
    public String toString() {
        return "Class: Super_1, superText: " + superText;
    }
}

class Sub_1 extends Super_1 {

    private final String subText;

    Sub_1(String subText) {
        super();
        this.subText = subText;
    }

    Sub_1(String superText, String subText) {
        super(superText);
        this.subText = subText;
    }

    @Override
    public String toString() {
        return super.toString() + "\nClass: " + this.getClass().getName() + ", subText: " + subText;
    }
}
