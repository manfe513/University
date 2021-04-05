/**
 * Пример 14.
 * <p>
 * Обработка исключения, порожденного одним методом m() в другом (в методе main).
 */

public class Task_14 {

    public static void m(int x) throws ArithmeticException {
        int h = 10 / x;
    }

    // размер массива= 0
    // Ошибка: Деление на ноль
    public static void main(String[] args) {

        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            m(l);

        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль");
        }
    }
}
