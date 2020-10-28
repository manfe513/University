/**
 * 8. Напишите программу со статическим методом,
 *
 * 1) аргументом которому передается целочисленный массив,
 *
 * 2) а результатом возвращается среднее значение для элементов массива
 * (сумма значений элементов, деленная на количество элементов в массиве).
 */
import java.util.Random;

public class ex_08 {

    public static void main(String[] args) {

        int[] arr = generateArray(5);
        printArray(arr);

        int averageValue = calculateAverageValue(arr);
        System.out.println("Average value = " + averageValue);
    }

    private static int[] generateArray(int size) {

        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) { arr[i] = rand.nextInt(10); }

        return arr;
    }

    private static int calculateAverageValue(int[] nums) {

        long total = 0;

        for(int i : nums) { total += i; }

        return (int) total / nums.length;
    }

    private static void printArray(int[] arr) {

        System.out.print("Array: ");

        for (int i : arr) { System.out.print(i + " "); }

        System.out.print("\n");
    }
}
