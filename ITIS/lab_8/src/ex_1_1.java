/**
 * Пример 1. Для заданного параметра x вывести
 * последовательность значений элементов числового ряда в
 * соответствии со следующими требованиями:
 * – очередной элемент x = 2*x+1 (новое значение вычисляется с
 * использованием старого);
 * – 0 ≤ x < 20.
 */

public class ex_1_1 {

    private static void calculate(int x) {

        System.out.println(x + " ");

        int result = 2*x+1;
        if (result < 20) {
            calculate(result);
        }
    }

    public static void main(String[] args) {
        calculate(1);
    }
}
