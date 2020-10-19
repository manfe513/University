/**
 * 4. Напишите программу, в которой описан статический метод для вычисления
 * двойного факториала числа, переданного аргументом методу.
 *
 * По определению, двойной факториал числа п (обозначается как n!!) — это произведение через одно всех чисел, не
 * больших числа n.
 *
 * То есть n!! = n * (n - 2) * (п - 4)* ... (последний множитель равен 1 для
 * нечетного п и равен 2 для четного n).
 *
 * Например:
 * 6!! = 6 х 4 х 2 = 48
 * 5!! = 5 х 3 х 1 = 15
 *
 * Предложите версию метода без рекурсии и с рекурсией.
 */
public class ex_04 {

    public static void main(String[] args) {

        doubleFactorial_without_recursion(6);
        doubleFactorial_with_recursion(5, 1);
    }

    private static void doubleFactorial_without_recursion(int num) {

        int result = 1;

        for(int i = num; i >= 1; i -= 2) {
            System.out.print(i);
            result *= i;

            if(i - 2 > 1) {
                System.out.print(" x ");
            }
        }

        System.out.println(" = " + result);
    }

    private static void doubleFactorial_with_recursion(int num, int total) {

        if(num < 1) {
            System.out.print(" = " + total);
            return;
        }

        System.out.print(num);
        total *= num;

        int nextNum = num - 2;
        if(nextNum >= 1) {
            System.out.print(" x ");
        }

        doubleFactorial_with_recursion(nextNum, total);
    }
}
