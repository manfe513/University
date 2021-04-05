/**
 * Пример 1. Сгенерировано и перехвачено RuntimeException.
 */
public class Task_1 {

    public static void main(String[] args) {

        try {
            //вывод текста в консоль
            System.out.println("0");

            //выброс исключения
            throw new RuntimeException("Unchecked exception");

        } catch (RuntimeException e) {

            //перехват исключения и вывод в консоль
            System.out.println("1 " + e);
        }

        //вывод после обработки исключения
        System.out.println("2");
    }
}
