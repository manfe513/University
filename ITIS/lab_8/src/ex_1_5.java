/**
 * Пример 5. Вывести число Фибоначчи, заданное его номером в
 * последовательности.
 * Последовательность Фибоначчи формируется так: нулевой член
 * последовательности равен нулю, первый – единице, а каждый
 * следующий – сумме двух предыдущих.
 */

public class ex_1_5 {

    private static int calculate(int x) {

        if (x == 0) return 0;
        else if (x == 1) return 1;

        return (x-2)+(x-1);
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci 8 = " + calculate(8));
    }
}
