/**
 * 6. Напишите программу со статическим методом, которому аргументом передается
 * целочисленный массив и целое число.
 *
 * 1) Результатом метод возвращает ссылку на новый массив, который получается из исходного массива
 * (переданного первым аргументом методу), если в нем взять несколько начальных элементов.
 *
 * 2) Количество элементов, которые нужно взять из исходного массива, определяются вторым аргументом метода.
 *
 * 3) Если второй аргумент метода больше длины массива, переданного первым аргументом, то методом
 * создается копия исходного массива и возвращается ссылка на эту копию.
 */
import java.util.Random;

public class ex_06 {

    public static void main(String[] args) {

        int[] arr = generateArray(5);
        printArray(arr);

        //копируем лишь часть массива
        int[] newArr = copyArrayElements(arr, 3);
        printArray(newArr);

        //передаём число Ю размера массива = копируем весь массив
        int[] newArr_2 = copyArrayElements(arr, 30);
        printArray(newArr_2);
    }

    private static int[] generateArray(int size) {

        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) { arr[i] = rand.nextInt(10); }

        return arr;
    }

    private static int[] copyArrayElements(int[] nums, int num) {

        int newArrLength = num <= nums.length ? num : nums.length;

        int[] newArr = new int[newArrLength];

        System.arraycopy(nums, 0, newArr, 0, newArrLength);

        return newArr;
    }

    private static void printArray(int[] arr) {

        for (int i : arr) { System.out.print(i + " "); }

        System.out.print("\n");
    }
}
