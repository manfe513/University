/**
 * 7. Напишите программу, в которой создается двумерный числовой массив
 * и этот массив заполняется «змейкой»: сначала первая строка (слева направо),
 * затем последний столбец (снизу вверх), вторая строка (слева направо) и так
 * далее.
 *
 *
 * Программа работает следующим образом:
 *
 * Первый проход - строка слева направо
 * 123 - порядок заполнения
 * ___
 *
 * 777
 * ###
 * ###
 *
 * Второй проход - колонка снизу вверх ДО 0ой строки, в которой уже есть цифра
 * 777
 * ##7 // - 2: порядок заполнения
 * ##7 // - 1: порядок заполнения
 *
 * и так далее.
 *
 * Если свернуть окно вывода до 5 строк в высоту - можно увидеть анимацию заполнения массива (с задержкой)
 */

import java.util.Random;

public class ex_07 {

    private static final Random rand = new Random();
    private static final int NUM_UPPER_BOUND = 10; //генерировать числа от 0 до 9 включительно

    public static void main(String[] args) {

        int rows = 5;
        int cols = 3;

        try {
            generateArray(rows, cols);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int[][] generateArray(int rows, int cols) throws InterruptedException {

        int rowsToFill = rows;
        int colsToFill = cols;

        int[][] nums = new int[rows][cols];

        for (int i = 0 ; i < rowsToFill; i++) {

            for (int j = 0; j < colsToFill; j++) { fillItem(nums, i, j); }
            rowsToFill--;

            for(int r = rows-1; r > i; r--) { fillItem(nums, r, colsToFill-1); }
            colsToFill--;

            if(colsToFill == 0) break;
        }

        return nums;
    }

    private static void fillItem(int[][] nums, int i, int j) throws InterruptedException {
        nums[i][j] = rand.nextInt(NUM_UPPER_BOUND);
        printArray(nums);
        Thread.sleep(700L);
    }

    private static void printArray(int[][] nums) {
        for(int[] intColumn : nums) {

            for(int num : intColumn) { System.out.print(num + " "); }

            System.out.println();
        }
    }
}
