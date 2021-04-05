/**
 * Пример 8. Генерация исключения в методе.
 *
 * Перехват брошенного исключения catch не производится.
 * Секция finally выполняется всегда.
 */

public class Task_8 {

    public static int m() {

        try {
            System.out.println("0");
            throw new RuntimeException();

        } finally {
            // блок будет выполнен всегда
            System.out.println("1");
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}
