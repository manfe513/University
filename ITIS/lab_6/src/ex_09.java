/**
 * 9. Напишите программу со статическим методом,
 *
 * 1) аргументом которому передается одномерный символьный массив.
 *
 * 2) В результате вызова метода элементы массива попарно меняются местами:
 * - первый — с последним,
 * - второй — с предпоследним
 * - и так далее.
 */
import java.util.Random;

public class ex_09 {

    public static void main(String[] args) {

        test(4);
        test(11);
    }

    private static void test(int arraySize) {
        char[] arr = generateArray(arraySize);
        printArray(arr);

        char[] newArr = swapLeftToRightElements(arr);
        printArray(newArr);
    }

    private static char[] generateArray(int size) {

        Random rand = new Random();
        char[] arr = new char[size];

        //26 - кол-во букв в латинском алфавите
        for (int i = 0; i < size; i++) { arr[i] = (char) ('a' + rand.nextInt(26)); }

        return arr;
    }

    private static char[] swapLeftToRightElements(char[] chars) {

        char[] newArr = new char[chars.length];

        //выполнять: если число элементов - чётное ИЛИ мы достигли элемента = сесредине массива с нечётным кол-вом элементов
        int arrayHalfSize = chars.length / 2;
        for(int i = 0;  (chars.length % 2 == 0 && i < arrayHalfSize) || (chars.length % 2 != 0 && i <= arrayHalfSize); i++) {

            int leftIndex = i;
            int rightIndex = chars.length - 1 - i;

            newArr[leftIndex] = chars[rightIndex];
            newArr[rightIndex] = chars[leftIndex];
        }

        return newArr;
    }

    private static void printArray(char[] arr) {

        for (char i : arr) { System.out.print(i + " "); }

        System.out.print("\n");
    }
}
