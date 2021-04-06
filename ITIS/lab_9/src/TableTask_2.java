import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Задание 2
 * В программе, где требуется из матрицы вывести столбец с номером, заданным с клавиатуры,
 * могут возникать ошибки в следующих случаях:
 * <p>
 * – ввод строки вместо числа;
 * – нет столбца с таким номером.
 */

public class TableTask_2 {

    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();

    private static final int MATRIX_SIZE = 4;
    private static final int[][] MATRIX = new int[MATRIX_SIZE][MATRIX_SIZE];

    public static void main(String[] args) {

        // Filling square matrix with numbers
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                MATRIX[i][j] = rand.nextInt(10);
            }
        }

        // print matrix
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                System.out.print(MATRIX[i][j] + " ");
            }
            System.out.println();
        }

        entryPoint();
    }

    private static void entryPoint() {

        try {
            printColumn(readColumnNumber());

        } catch (InputMismatchException e) {
            System.out.println("Введено некорректное значение столбца, столбец - целое число" + e);
            sc.next();
            entryPoint();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Столбец с таким номером отсутствует" + e);
            entryPoint();
        }
    }

    private static int readColumnNumber() {

        System.out.println("Введите номер столбца (от 0 до "+ (MATRIX.length-1) +"): ");

        return sc.nextInt();
    }

    private static void printColumn(int colNumber) {

        for (int i = 0; i < MATRIX_SIZE; i++)
            System.out.println(MATRIX[i][colNumber]);
    }
}
