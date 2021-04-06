import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Задание 3
 * В программе, вычисляющей сумму элементов типа byte одномерного массива, вводимого с клавиатуры,
 * могут возникать ошибки в следующих случаях:
 * – ввод строки вместо числа;
 * – ввод или вычисление значения за границами диапазона типа.
 */

public class TableTask_3 {

    private static final Scanner sc = new Scanner(System.in);

    private static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {

        entryPoint();
    }

    private static void entryPoint() {

        byte[] nums = new byte[ARRAY_SIZE];

        try {
            readNums(nums);
            printNums(nums);

        } catch (InputMismatchException e) {
            System.out.println("Введено некорректное значение" + e);
            sc.next();
            entryPoint();

        } catch (ByteRangeExceededException e) {
            System.out.println(e);
            entryPoint();

        }
    }

    private static void readNums(byte[] nums) throws ByteRangeExceededException {

        for (int i = 0; i < ARRAY_SIZE; i++) {

            System.out.println("Введите число (от -128 до 127): ");

            int num = sc.nextInt();

            if(num < Byte.MIN_VALUE || num > Byte.MAX_VALUE) throw new ByteRangeExceededException();

            nums[i] = (byte) num;
        }
    }

    private static void printNums(byte[] nums) {

        for (byte num :
                nums) {
            System.out.print(num + " ");
        }
    }

    static class ByteRangeExceededException extends Exception {

        ByteRangeExceededException() {
            super("Число за пределами диапазона");
        }
    }
}
