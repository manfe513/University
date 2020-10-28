/**
 * 10. Напишите программу со статическим методом,
 *
 * 1) аргументом которому передается произвольное количество целочисленных аргументов.
 *
 * 2) Результатом метод возвращает массив из двух элементов, это:
 * - значения наибольшего
 * - и наименьшего значений
 * среди аргументов, переданных методу.
 */

public class ex_10 {

    public static void main(String[] args) {

        //min = 1
        //max = 7
        findMinAndMax(1,2,7,3);
    }

    private static void findMinAndMax(int... nums) {

        printArray(nums);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : nums) {

            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        System.out.println("min = " + min + ", max = " + max);
    }

    private static void printArray(int[] arr) {

        System.out.print("Array: ");

        for (int i : arr) { System.out.print(i + " "); }

        System.out.print("\n");
    }
}
