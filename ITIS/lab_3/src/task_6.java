/**
 * Напишите программу, в которой создается одномерный числовой
 * массив и заполняется числами, которые при делении на 5 дают в остатке 2
 * (числа 2, 7,12,17 и так далее). Размер массива вводится пользователем.
 * Предусмотреть обработку ошибки, связанной с вводом некорректного
 * значения.
 */

import java.util.Random;

public class task_6 {

    private static final Random rand = new Random();

    public static void main(String[] args) {
        printSequence();
    }

    private static void printSequence() {

        int arraySize = Helper.readNum("Введите размер массива: ");

        if(arraySize < 2) {
            System.out.println("Размер массива не является показательным для последовательности");
            printSequence();
            return;
        }

        long[] numsArray = new long[arraySize];

        for (int i = 0; i < numsArray.length; i++) {
            numsArray[i] = generateNum();
        }


        System.out.println("Получившаяся последовательность чисел:");
        for(long sequenseItem : numsArray) {
            System.out.printf("%d ", sequenseItem);
        }
    }

    /**
     *  Генерирует число, которое при делении на 5 в остатке даёт 2
     *  выбор чисел производится в диапазоне 0-100
     */
    private static int generateNum() {
        int num = rand.nextInt(100);

        if(num % 5 == 2) return num;
        else return generateNum();
    }
}
