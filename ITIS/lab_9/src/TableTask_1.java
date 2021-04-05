import java.util.ArrayList;

/**
 * Таблица заданий - 2:
 * Задание 1
 *
 * В программе, вычисляющей среднее значение среди положительных элементов одномерного массива (тип элементов int),
 * вводимого с клавиатуры, могут возникать ошибки в следующих случаях:
 * – ввод строки вместо числа;
 * – несоответствие числового типа данных;
 * – положительные элементы отсутствуют.
 */

public class TableTask_1 {

    public static void main(String[] args) {

        int[] nums = Helper.recursiveNumsInput(null);

        for (int num :
                nums) {
            System.out.println("num = " + num);
        }
    }
}
