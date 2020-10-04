/**
 * Напишите программу, в которой создается массив п заполняется
 * случайными числами.
 * Массив отображается в консольном окне.
 * <p>
 * > В этом массиве необходимо определить элемент с минимальным значением.
 * > В частности, программа должна вывести значение элемента с минимальным
 * значением и индекс этого элемента.
 * > Если элементов с минимальным
 * значением несколько, должны быть выведены индексы всех этих элементов
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class task_9 {

    private static final int ARRAY_SIZE = 10;
    private static final int ARRAY_NUMBER_BOUNDARY = 5; //верхняя граница чисел для генерации
    private static final Random rand = new Random();

    public static void main(String[] args) {
        printSequence();
    }

    private static void printSequence() {

        int[] nums = generateArray();

        System.out.println("Исходный массив чисел:");
        printNums(nums);

        findMinElements(nums);
    }

    private static void findMinElements(int[] nums) {

        //карта: индекс - число
        Map<Integer, Integer> indexToNumMap = new HashMap<>();

        int minNum = Integer.MAX_VALUE;
        int minElementsCount = 1;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            indexToNumMap.put(i, num);

            if(num < minNum) {
                minNum = num;

                minElementsCount = 1;

            } else if (num == minNum) {
                minElementsCount++;
            }
        }

        //Если минимальный элемент один - вывести только его
        if(minElementsCount == 1) {
            System.out.println("Минимальное число: " + minNum);

        } else {
            //Если в массиве несколько одинаковых мин. элементов - вывести их все с индексами
            printAllMinElements(indexToNumMap, minNum);
        }
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

    private static void printAllMinElements(Map<Integer, Integer> indexToNumMap, int minNum) {

        System.out.println("\nМинимальные элемменты массива: ");

        for(Map.Entry<Integer, Integer> entry : indexToNumMap.entrySet()) {

            if(entry.getValue() == minNum) {
                System.out.println("Значение: " + entry.getValue() + ", индекс: " + entry.getKey());
            }
        }
    }
}
