/**
 * 2. Напишите программу с классом, у которого есть два символьных поля и
 * метод.
 * <p>
 * > Метод возвращает результат, и у него нет аргументов.
 * > При вызове метод выводит в консольное окно все символы из кодовой таблицы, которые
 * находятся «между» символами, являющимися значениями полей объекта (из
 * которого вызывается метод).
 * <p>
 * Например, если полям объекта присвоены
 * значения ‘A’ и ‘D’, то при вызове метода в консольное окно должны
 * выводиться все символы от ‘A’ до ‘D’ включительно.
 */

public class ex_02 {

    public static void main(String[] args) {

        Sample_02 sample = new Sample_02('A', 'F');
        sample.printCharsSequence();
    }
}

class Sample_02 {

    private char firstChar;
    private char secondChar;

    private Sample_02() {
        throw new IllegalStateException("Вызван запрещённый конструктор! Используйте параметризированный");
    }

    Sample_02(char firstChar, char secondChar) {
        this.firstChar = firstChar;
        this.secondChar = secondChar;
    }

    void printCharsSequence() {
        int firstCharCode = (int) firstChar;
        int secondCharCode = (int) secondChar;

        for(int i = firstCharCode; i <= secondCharCode; i++) {
            System.out.println("Char value: " + (char) i);
        }
    }
}


