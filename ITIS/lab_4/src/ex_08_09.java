/**
 * 8. Напишите программу «Шифр Цезаря», которая зашифровывает
 * введенный текст.
 * Используете кодовую таблицу символов.
 *
 * 1) При запуске программы в консоль необходимо вывести сообщение:
 * «Введите текст для шифрования»,
 *
 * 2) После ввода текста, появляется сообщение: «Введите ключ».
 *
 * 3) После того как введены все данные, необходимо вывести преобразованную
 * строку с сообщением «Текст после преобразования : ».
 *
 * 4) Далее необходимо задать вопрос пользователю: «Выполнить обратное преобразование? (y/n)»:
 * - если пользователь вводит «y», тогда выполнить обратное преобразование.
 * - если пользователь вводит «n», того программа выводит сообщение «До свидания!».
 *
 * 5) Если пользователь вводит что-то другое, отличное от «y» или «n»,
 * то программа ему выводит сообщение: «Введите корректный ответ».
 */

import java.util.Scanner;

public class ex_08_09 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter shift number: ");
        int shift = sc.nextInt();

        //чтобы прочесть '\n' после ввода числа, т.к. nextInt игнорирует его
        sc.nextLine();

        Cipher cipher = new Cipher(shift);

        String input = getInput(cipher);

        cipher.processEncodeDecode(input);
    }

    private static String getInput(Cipher cipher) {

        System.out.print("Enter text (only latin alphabet: lower + upper cased),\nor type 'q' to quit: ");
        String input = sc.nextLine();

        if(input.equals("q")) {
            System.exit(0);
        }

        if(!cipher.isValidInput(input)) {
            System.out.println("Sorry, input has incorrect symbols, only latin alphabet: lower + upper cased");
            return getInput(cipher);
        }

        return input;
    }
}

class Cipher {

    private static final int CHAR_POS_NOT_FOUND = -1;

    private static final String UNEXPECTED_CHAR_ERROR_TEXT_TEMPLATE =
            "Sorry, char %c is unsupported, only latin alphabet: lower + upper cased";

    private final int shift;

    private Cipher() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Sorry, no-arg consctructor disabled nor now :(");
    }

    Cipher(int shift) {
        this.shift = shift;
    }

    private final char[] chars = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',

            'A', 'B', 'C', 'D', 'C', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '
    };

    boolean isValidInput(String input) {

        char[] chars = input.toCharArray();

        for(char ch : chars) {
            if(charPosition(ch) == CHAR_POS_NOT_FOUND) return false;
        }

        return true;
    }

    void processEncodeDecode(String input) {

        String encoded = encode(input);
        System.out.printf("Encoded: %s\n", encoded);

        String decoded = decode(encoded);
        System.out.printf("Decoded: %s\n", decoded);
    }

    String encode(String input) {
        return processShift(input, +shift);
    }

    String decode(String input) {
        return processShift(input, -shift);
    }

    String processShift(String input, int shift) {

        char[] inputChars = input.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(char ch : inputChars) {

            /**
             * Версия ссдвига по заданной таблице символов [chars]
             */
            int charPosition = charPosition(ch);
            char replacementChar = getReplacementChar(charPosition, shift);

            /**
             * Версия ссдвига по стандартной таблице символов unicode,
             * единственное - тут ещё можно снять ограничение на латинские символы
             */
//            char replacementChar = (char) (ch + shift);

            sb.append(replacementChar);
        }

        return sb.toString();
    }

    private int charPosition(char ch) {

        for(int i = 0; i < chars.length; i++) {

            if(chars[i] == ch) {
                return i;
            }
        }

        return CHAR_POS_NOT_FOUND;
    }

    private char getReplacementChar(int charPosition, int shift) {

        int newPos = charPosition + shift;;

        if(newPos >= chars.length) {
            newPos %= chars.length;
            newPos--;
        }

        if(newPos < 0) {
            newPos = (chars.length) - (Math.abs(newPos) % chars.length);
        }

        return chars[newPos];
    }
}
