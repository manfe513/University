/**
 * Пример 10.
 *
 * Генерация исключительной ситуации в методе.
 * Использование оператора return в секциях try и finally.
 */

public class Task_10 {

    public static int m() {

        try {

            // будет выведено
            System.out.println("0");
            return 15;

        } finally {

            // будет выведено
            System.out.println("1");
            return 20;
        }
    }

    public static void main(String[] args) {

        // будет выведено "20"
        System.out.println(m());
    }
}
