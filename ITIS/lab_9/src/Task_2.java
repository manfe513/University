/**
 * Пример 2. Исключение перехвачено перехватчиком предка.
 */

public class Task_2 {

    public static void main(String[] args) {

        try {
            //вывод текста в консоль
            System.out.println("0");

            //выброс исключения
            throw new RuntimeException("Unchecked exception");

            // это сообщение не будет выведено + среда разработки не даст запустить эту программу
            //System.out.println("1");

        } catch (RuntimeException e) {

            //перехват исключения и вывод в консоль
            System.out.println("2 " + e);
        }

        //вывод после обработки исключения
        System.out.println("3");
    }
}
