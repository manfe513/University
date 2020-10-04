/**
 * Напишите программу, в которой создается одномерный
 * символьный массив из 10 элементов.
 * Массив заполняется буквами «через одну», начиная с буквы ' а ':
 * то есть массив заполняется буквами ' а ' , ' с ' , ' е ' , ' д ' и так далее.
 *
 * > Отобразите массив в консольном окне в прямом и обратном порядке.
 * > Размер массива задается переменной.
 */

import java.util.*;

public class task_7 {

    private static final int CHAR_ARRAY_SIZE = 10;

    public static void main(String[] args) {
        printSequence();
    }

    private static void printSequence() {

        char[] chars = genrateCharsArray();

        System.out.println("Исходный массив символов:");
        printChars(chars);

        Arrays.sort(chars);

        System.out.println("\nОтсортированный в прямом порядке:");
        printChars(chars);

        List<Character> charList = new ArrayList<>();
        for(char ch : chars) {
            charList.add(ch);
        }

        charList.sort(Collections.reverseOrder());

        System.out.println("\nОтсортированный в обратном порядке: ");
        for(Character character : charList) {
            System.out.print(character + " ");
        }
    }

    private static char[] genrateCharsArray() {

        char[] chars = new char[CHAR_ARRAY_SIZE];
        int iter = 0;

        for(char ch = 'a'; iter < CHAR_ARRAY_SIZE; ch += 2) {
            chars[iter] = ch;
            iter++;
        }

        return chars;
    }

    private static void printChars(char[] chars) {
        for(char ch : chars) {
            System.out.print(ch + " ");
        }
    }
}
