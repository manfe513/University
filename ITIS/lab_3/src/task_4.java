/**
 * Напишите программу, в которой пользователем вводится два
 * целых числа. Программа выводит все целые числа — начиная с наименьшего
 * (из двух введенных чисел) и заканчивая наибольшим (из двух введенных
 * чисел). Предложите разные версии программы (с использованием разных
 * операторов цикла).
 */
public class task_4 {

    public static void main(String[] args) {

        checkNums();
    }

    private static void checkNums() {
        int num1 = Helper.readNum("Введите число 1: ");
        int num2 = Helper.readNum("Введите число 2: ");

        if(num1 < num2) {
            printSequence(num1, num2);

        } else {
            printSequence(num2, num1);
        }
    }

    private static void printSequence(int min, int max) {

        System.out.println("Последовательность целых чисел от меньшего к большему:");
        for(int i = min; i <= max; i++) {
            System.out.print(i + " ");
        }
    }
}
