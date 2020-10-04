/**
 * Программа выводит последовательноссть чисел Фибоначчи
 *
 * В закомментированном блоке показан способ заполнения последоавтельности при помощи оператора while
 */

public class task_3 {

    public static void main(String[] args) {
        printFibonacci();
    }

    private static void printFibonacci() {

        int numCount = Helper.readNum("Введите количество чисел последовательности (>=3): ");

        if(numCount < 3) {
            System.out.println("Число не является показательным для последовательности");
            printFibonacci();
            return;
        }

        long[] numsArray = new long[numCount];
        numsArray[0] = numsArray[1] = 1;

        for (int i = 2; i < numCount; i++) {
            numsArray[i] = numsArray[i-1] + numsArray[i-2];
        }

        /**
         * Вариант заполнения массива последовательности при помощи оператора while
         */
//        int i = 2;
//        while (i < numCount) {
//            numsArray[i] = numsArray[i-1] + numsArray[i-2];
//            i++;
//        }

        System.out.println("Получившаяся последовательность Фибоначчи:");
        for(long sequenseItem : numsArray) {
            System.out.printf("%d ", sequenseItem);
        }
    }
}
