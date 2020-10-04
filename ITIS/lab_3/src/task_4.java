/**
 * Напишите программу, в которой вычисляется сумма чисел,
 * удовлетворяющих таким критериям: при делении числа на 5 в остатке получается 2,
 * или при делении на 3 в остатке получается 1. Количество чисел в сумме
 * вводится пользователем. Программа отображает числа, которые
 * суммируются, и значение суммы. Предложите версии программы,
 * использующие разные операторы цикла.
 */

import java.util.Random;

public class task_4 {

    private static final Random rand = new Random();

    public static void main(String[] args) {

        checkNums();
    }

    private static void checkNums() {
        int numsInSum = Helper.readNum("Введите количествво чисел в сумме: ");

        int[] nums = new int[numsInSum];
        int sum;
        int iter;

        do {
            //Решение "в лоб", будет работать непредсказуемо долго на больших размерах [numsInSum]
            for(iter = 0; iter < numsInSum; iter++) {
                nums[iter] = rand.nextInt(100);
            }

            sum = 0;
            for(int num : nums) {
                sum += num;
            }

        } while(sum % 5 != 2 && sum % 3 != 1);

        printSequence(nums, sum);
    }

    private static void printSequence(int[] nums, int sum) {

        System.out.println("Числа, удовлетворяющие условию: " +
                "\"сумма чисел при делении на 5 в остатке получается 2, \nИЛИ при делении на 3 вв остатке получается 1\":");

        for(int i = 0; i < nums.length-1; i++) {
            System.out.print(nums[i] + " + ");
        }
        System.out.print(nums[nums.length-1] + " = " + sum);
    }
}
