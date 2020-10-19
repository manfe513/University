/**
 * 5. Напишите программу со статическим методом, которым вычисляется сумма
 * квадратов натуральных чисел 1^2 + 2^2 + 3^2 + ... + n^2.
 * <p>
 * Число n передается аргументом методу.
 * <p>
 * Предложите версию метода с рекурсией и без рекурсии.
 * <p>
 * Для проверки результата можно
 * использовать формулу 1^2 + 2^2 +3^2+…+n2 =(n+1)x(2n+1)/6
 */
public class ex_05 {

    public static void main(String[] args) {

        sumOfSquares(5);
        sumOfSquares_recursion(5, 1, 0);
    }

    private static void sumOfSquares(int num) {

        int result = 0;

        for (int i = 1; i <= num; i++) {
            System.out.print(i + "^2");
            result += i * i;

            if (i + 1 <= num) {
                System.out.print(" + ");
            }
        }

        System.out.println(" = " + result);
    }

    private static void sumOfSquares_recursion(int num, int i, int total) {

        System.out.print(i + "^2");
        total += i * i;

        int nextIter = i + 1;
        if (nextIter <= num) {
            System.out.print(" + ");
        }

        if (i == num) System.out.print(" = " + total);
        else sumOfSquares_recursion(num, nextIter, total);
    }
}
