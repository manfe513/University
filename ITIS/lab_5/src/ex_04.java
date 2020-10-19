/**
 * 4. Напишите программу с классом, у которого есть символьное и
 * целочисленное поле.
 *
 * 1) В классе должны быть описаны версии конструктора с двумя аргументами (целое число и символ – определяют значения полей), а
 * также с одним аргументом типа double.
 *
 * 2) В последнем случае действительная часть аргумента определяет код символа (значение символьного поля), а
 * дробная часть (с учетом десятых и сотых) определяет значение
 * целочисленного поля.
 *
 * Например, если аргументом передается число 65.1267,
 * то значением символьного поля будет символ ‘A’ с годом 65, а целочисленное
 * поле получит значение 12 (в дробной части учитываются только десятые и
 * сотые).
 */

public class ex_04 {

    public static void main(String[] args) {

        Sample_04 sample = new Sample_04(5, 'C');
        sample.print();

        sample = new Sample_04(65.1267);
        sample.print();
    }
}

class Sample_04 {

    private final char ch;
    private final int num;

    Sample_04(int num, char ch) {
        System.out.println("Sample_03(int num, char ch) констсруктор вызван");

        this.num = num;
        this.ch = ch;
    }

    Sample_04(double numFloat) {
        System.out.println("Sample_04(double numFloat) констсруктор вызван");

        String numStr = String.valueOf(numFloat);
        String[] numParts = numStr.split("\\.");

        int charCode = Integer.parseInt(numParts[0]);
        String numPartStr = numParts[1];
        String numPart = numPartStr.length() > 2 ? numPartStr.substring(0, 2) : numPartStr;

        this.ch = (char) charCode;
        this.num = Integer.parseInt(numPart);
    }

    void print() {
        System.out.println("ch = " + ch);
        System.out.println("num = " + num);
    }
}


