/**
 * Пример 9.
 *
 * Генерация исключительной ситуации в методе
 * и дополнительное использование оператора return.
 */

public class Task_9 {

    public static int m() {

        try {
            System.out.println("0");
            return 55; // выход из метода

        } finally {
            //будет вызван
            System.out.println("1");
        }
    }

    public static void main(String[] args) {

        // выведет "55"
        System.out.println(m());
    }
}
