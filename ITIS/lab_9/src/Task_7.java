/**
 * Пример 7.
 *
 * Нельзя перехватить брошенное исключение с помощью чужого catch,
 * даже если перехватчик подходит.
 */

public class Task_7 {

    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");

        } catch (NullPointerException e) {

            System.out.println("1" );
            throw new ArithmeticException(); // будет выброшено и не обработано

        } catch (ArithmeticException e) {
            System.out.println("2" );
        }

        System.out.println("3");
    }
}
