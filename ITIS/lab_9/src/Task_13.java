/**
 * Пример 13.
 * <p>
 * Пример работы с аргументами метода main.
 * На рисунке 5 представлена настройка проекта и задание входных значений аргументов.
 */

public class Task_13 {

    // размер массива= 2
    // Индекс не существует
    public static void main(String[] args) {

        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            int h = 10 / l;
            args[l + 1] = "10";

        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс не существует");
        }
    }
}
