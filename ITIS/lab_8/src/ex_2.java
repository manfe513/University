/**
 * 2. Создать приложение с использованием рекурсии для перевода
 * целого числа, введенного с клавиатуры, в двоичную систему счисления.
 */

public class ex_2 {

    private static String convert_10_to_2_recursive(int x) {

        if (x == 0) return "0";

        int divisionResult = x / 2;
        int remainder = x % 2;

        return convert_10_to_2_recursive(divisionResult) + remainder;
    }

    public static void main(String[] args) {

        int num = Helper.readNum();

        System.out.println(num + "(10) = " + convert_10_to_2_recursive(num) + "(2)");
    }
}
