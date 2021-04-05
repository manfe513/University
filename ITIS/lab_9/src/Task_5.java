/**
 * Пример 5. Исключение не перехвачено.
 */

public class Task_5 {

    public static void main(String[] args) {

        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");

        } catch (NullPointerException e) {

            // метод не будет вызван
            System.out.println("1");
        }

        // метод не будет вызван
        System.out.println("2");
    }
}
