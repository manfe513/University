/**
 * Пример 3. Перехват исключения подходящим классом.
 */

public class Task_3 {

    public static void main(String[] args) {

        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");

        } catch (NullPointerException e) {
            System.out.println("1");

        } catch (RuntimeException e) {

            //будет вызван этот метод
            System.out.println("2");

        } catch (Exception e) {
            System.out.println("3");
        }

        System.out.println("4");
    }
}
