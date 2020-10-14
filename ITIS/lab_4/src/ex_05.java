/**
 * 5. Напишите программу, в которой создается двумерный
 * целочисленный массив. Он заполняется случайными числами. Затем в этом
 * массиве строи и столбцы меняются местами: первая строка становится первым
 * столбцом, вторая строка становиться вторым столбцом и так далее. Например,
 * если исходный массив состоял из 3 строк и 5 столбцов, то в итоге получаем
 * массив из 5 строк и 3 столбцов.
 */

import java.util.Random;

public class ex_05 {

    private static final Random rand = new Random();
    private static final int NUM_UPPER_BOUND = 10; //генерировать числа от 0 до 9 включительно

    public static void main(String[] args) {

        int rows = 5;
        int cols = 3;

        int[][] nums = generateArray(rows, cols);
        printArray(nums);

        int[][] transpositionedNums = switchRowsCols(nums);
        printArray(transpositionedNums);
    }

    private static int[][] generateArray(int rows, int cols) {

        int[][] nums = new int[rows][cols];

        for (int i = 0 ; i < rows; i++){
            for (int j = 0; j < cols; j++){ nums[i][j] = rand.nextInt(NUM_UPPER_BOUND); }
        }

        return nums;
    }

    private static void printArray(int[][] nums) {
        for(int[] intColumn : nums) {

            for(int num : intColumn) { System.out.print(num + " "); }

            System.out.println();
        }
    }

    private static int[][] switchRowsCols(int[][] nums) {

        int newArrayRows = nums[0].length;
        int newArrayCols = nums.length;

        int[][] newArray = new int[newArrayRows][newArrayCols];

        for(int i = 0; i < newArrayRows; i++) {

            for(int j = 0; j < newArrayCols; j++) {

                newArray[i][j] = nums[j][i];
            }

            System.out.println();
        }

        return newArray;
    }
}
