/**
 * Напишите программу, в которой создается целочисленный
 * массив, заполняется случайными числами и после этого значения элементов в
 * массиве сортируются в порядке убывания значений.
 */

import java.util.Arrays;
import java.util.Random;

public class task_10 {

    private static final int ARRAY_SIZE = 10;
    private static final int ARRAY_NUMBER_BOUNDARY = 20; //верхняя граница чисел для генерации
    private static final Random rand = new Random();

    public static void main(String[] args) {
        printSequence();
    }

    private static void printSequence() {

        int[] nums = generateArray();

        System.out.println("Исходный массив чисел:");
        printNums(nums);

        printArrayReversed(nums);
    }

    private static int[] generateArray() {

        int[] nums = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            nums[i] = rand.nextInt(ARRAY_NUMBER_BOUNDARY);
        }

        return nums;
    }

    private static void printNums(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void printArrayReversed(int[] nums) {

        Arrays.sort(nums);

        System.out.println("\nМассив, отсортированный в обратном порядке:");

        for(int i = nums.length - 1; i >=0; i--) {
            System.out.print(nums[i] + " ");
        }
    }
}
