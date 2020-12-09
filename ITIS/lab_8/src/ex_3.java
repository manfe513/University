import java.util.ArrayList;
import java.util.Scanner;

/**
 * 3. Создать приложение, позволяющее ввести и вывести
 * одномерный массив целых чисел. Для ввода и вывода массива
 * разработать рекурсивные методы вместо циклов for.
 */

public class ex_3 {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Для наглядности предлагается вводить числа:
     * 1
     * 2
     * 3
     * -1
     */
    public static void main(String[] args) {

        printRecursive(Helper.recursiveNumsInput(new ArrayList<>()));
    }

    private static void printRecursive(ArrayList<Integer> nums) {

        if(nums.size() == 0) {
            System.out.println();
            return;
        }

        int num = nums.remove(0);
        System.out.print(num + " ");

        printRecursive(nums);
    }
}
