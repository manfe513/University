/**
 * 7. Напишите программу, в которой создается двумерный числовой массив
 * и этот массив заполняется «змейкой»: сначала первая строка (слева направо),
 * затем последний столбец (снизу вверх), вторая строка (слева направо) и так
 * далее.
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

        //todo: think
        for (int i = 0 ; i < rows; i++) {

            if(rowsToFill == 0) continue;
            for (int j = 0; j < cols; j++) { fillItem(nums, i, j); }
            rowsToFill--;

            if(colsToFill == 0) continue;
            for(int k = rows-1; k >= rows-rowsToFill; k--) {
                for (int j = colsToFill-1; j >= 0; j--) { fillItem(nums, k, j); }
            }
            colsToFill--;
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
