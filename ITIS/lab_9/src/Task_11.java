/**
 * Пример 11.
 * <p>
 * Генерация исключительной ситуации в методе.
 * Использование оператора return в секциях try и finally.
 */

public class Task_11 {

    // выведет: 0 1 2 3
    public static void main(String[] args) {

        try {

            // будет выведено
            System.out.println("0");
            throw new NullPointerException("ошибка");

        } catch (NullPointerException e) {

            System.out.println("1");

        } finally {

            // будет выведено
            System.out.println("2");
        }

        System.out.println("3");
    }
}
