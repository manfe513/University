/**
 * 7. Напишите программу со статическим методом,
 *
 * 1) аргументом которому передастся символьный массив,
 * 2) а результатом возвращается ссылка на целочисленным массив, состоящий из кодов символов из массива- аргумента.
 */
import java.util.Random;

public class ex_07 {

    public static void main(String[] args) {

        char[] arr = generateArray(5);
        printArray(arr);

        int[] newArr = getCharsCodes(arr);
        printCharsCodes(newArr);
    }

    private static char[] generateArray(int size) {

        Random rand = new Random();
        char[] arr = new char[size];

        //26 - кол-во букв в латинском алфавите
        for (int i = 0; i < size; i++) { arr[i] = (char) ('a' + rand.nextInt(26)); }

        return arr;
    }

    private static int[] getCharsCodes(char[] chars) {

        int[] newArr = new int[chars.length];

        for(int i = 0; i < chars.length; i++) { newArr[i] = chars[i]; }

        return newArr;
    }

    private static void printArray(char[] arr) {

        for (char i : arr) { System.out.print(i + " "); }

        System.out.print("\n");
    }

    private static void printCharsCodes(int[] arr) {

        System.out.println("Chars codes: ");

        for (int i : arr) { System.out.print(i + " "); }

        System.out.print("\n");
    }
}
