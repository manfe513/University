/**
 * 6. Напишите программу, в которой создается и инициализируется
 * двумерный числовой массив. Затем из этого массива удаляется строка и
 * столбец (создается новый массив, в котором по сравнению с исходным
 * удалена одна строка и один столбец). Индекс удаляемой строки и индекс
 * удаляемого столбца определяется с помощью генератора случайных чисел.
 */

import java.util.Random;

public class ex_06 {

    private static final Random rand = new Random();
    private static final int NUM_UPPER_BOUND = 10; //генерировать числа от 0 до 9 включительно

    public static void main(String[] args) {

        int rows = 5;
        int cols = 3;

        int[][] nums = generateArray(rows, cols);
        printArray(nums);

        int[][] cuttedNums = cutOneRowAndOneCol(nums);
        printArray(cuttedNums);
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

    private static int[][] cutOneRowAndOneCol(int[][] nums) {

        int rowsCount = nums.length;
        int colsCount = nums[0].length;

        int newRowsCount = rowsCount - 1;
        int newColsCount = colsCount - 1;

        int rowIndexToCut = rand.nextInt(rowsCount - 1);
        int colIndexToCut = rand.nextInt(colsCount - 1);

        System.out.println("Вырежем строку с индексом: " + rowIndexToCut);
        System.out.println("Вырежем столбец с индексом: " + colIndexToCut);

        int[][] newArray = new int[newRowsCount][newColsCount];

        for(int row = 0, newRow = 0; row < rowsCount; row++, newRow++) {
            if(row == rowIndexToCut) {
                newRow--;
                continue;
            }

            for(int col = 0, newCol = 0; col < colsCount; col++, newCol++) {
                if(col == colIndexToCut) {
                    newCol--;
                    continue;
                }

                newArray[newRow][newCol] = nums[row][col];
            }

            System.out.println();
        }

        return newArray;
    }
}
