/**
 * Напишите программу, в которой создается символьный массив из
 * 10 элементов.
 * Массив заполнить большими (прописными) буквами английского алфавита.
 * Буквы берутся подряд, но только согласные (то есть гласные буквы ’А' , 'Е' и 'I'
 * при присваивании значений элементам массива нужно пропустить).
 *
 * > Отобразите содержимое созданного массива в консольном
 * окне.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class task_8 {

    private static final int CHAR_ARRAY_SIZE = 10;

    public static void main(String[] args) {
        printSequence();
    }

    private static void printSequence() {

        char[] chars = genrateCharsArray();

        System.out.println("Итоговый массив символов:");
        printChars(chars);
    }

    private static char[] genrateCharsArray() {

        char[] chars = new char[CHAR_ARRAY_SIZE];
        int iter = 0;

        for(char ch = 'A'; iter < CHAR_ARRAY_SIZE; ch++) {

            if(ch == 'A' || ch == 'E' || ch == 'I')
                continue;

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
