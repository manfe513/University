/**
 * Пример 4. Вычислить факториал числа n с использованием
 * рекурсии.
 * Факториал числа n (обозначается n!) – произведение всех натуральных
 * чисел от 1 до n включительно: n!=1*2*…*n. Пример 5!=1*2*3*4*5 =4!*5.
 * Можно записать n!=(n-1)!*n.
 */

public class ex_1_4 {

    private static int calculate(int x) {

        if(x == 1) return 1;

        return x * calculate(x-1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial 5 = " + calculate(5));
    }
}
