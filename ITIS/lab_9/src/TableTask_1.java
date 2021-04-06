import java.util.Scanner;

/**
 * Таблица заданий - 2:
 * Задание 1
 * <p>
 * В программе, вычисляющей среднее значение среди положительных элементов одномерного массива (тип элементов int),
 * вводимого с клавиатуры, могут возникать ошибки в следующих случаях:
 *
 * - ввод строки вместо числа;
 * - несоответствие числового типа данных;
 * - положительные элементы отсутствуют.
 */

public class TableTask_1 {

    private static final Scanner sc = new Scanner(System.in);
    private static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {

        int[] nums = new int[ARRAY_SIZE];

        entryPoint(nums);
    }

    private static void entryPoint(int[] nums) {

        // Если чтение входных данных не удалось - рекурсивный повтор ввода сначала
        if(readNums(nums)) calculateMedian(nums);
        else entryPoint(nums);
    }

    private static boolean readNums(int[] nums) {
        try {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                System.out.println("Введите число: ");
                nums[i] = sc.nextInt();
            }
            return true;

        } catch (Exception e) {
            System.out.println("Ошибка ввода данных " + e);
            return false;
        }
    }

    private static void calculateMedian(int[] nums) {

        long total;

        try {
            total = calculateTotalOfPositiveNums(nums);

        } catch (NoPositiveNumsException e) {
            System.out.println("Ошибка " + e);
            entryPoint(nums);
            return;
        }

        double median = (double) total / nums.length;

        System.out.println("Среднее значение = " + median);
    }

    private static long calculateTotalOfPositiveNums(int[] nums) throws NoPositiveNumsException {
        long total = 0;
        boolean hasPositiveNums = false;

        for (int num : nums) {
            if(num > 0) {
                total += num;
                hasPositiveNums = true;
            }
        }

        if(!hasPositiveNums) {
            throw new NoPositiveNumsException();
        }

        return total;
    }

    static class NoPositiveNumsException extends Exception {
        NoPositiveNumsException() {
            super("Нет положительных элементов в массиве");
        }
    }
}
