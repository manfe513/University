import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Задание 3.
 * Создать проект, позволяющий из одного текстового файла,
 * содержащего несколько строк (тип String) заранее подготовленного текста на русском языке (Пушкин, Лермонтов или другой российсмки классик на Ваш вкус),
 * построчно переписать в другой текстовый файл слова начинающиеся с согласных букв..
 * <p>
 * Требования:
 * – слова из предложения выделять методом split();
 * – в новом файле следует указать номер строки, в которой иско- мые слова находились в исходном файле;
 * – для каждой строки указать количество выбранных слов.
 */
public class Task_3 {

    private static char[] CONSONANTS_RU = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};

    public static void main(String[] args) {

        BufferedReader in = null;
        FileWriter out = null;

        try {
            // Создание потоков
            in = new BufferedReader(
                    new InputStreamReader(new FileInputStream("task3-file1.txt"), Charset.forName("cp1251"))
            );
            out = new FileWriter("task3-file2.txt");

            try {

                String s;
                int lineNumber = 1;
                while ((s = in.readLine()) != null) {

                    String[] words = s.split(" ");
                    for (String word : words) {

                        if(startsWithConsonant(word)) {
                            out.write(lineNumber + ":" + word +"\n");
                        }
                    }
                    lineNumber++;
                }
            } catch (EOFException ignore) {
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка !!!!!!!!");

        } finally {
            try {
                out.flush();
                out.close();
            } catch (IOException ignore) {
            }
        }
    }

    private static boolean startsWithConsonant(String word) {

        char firstChar = word.toLowerCase().charAt(0);

        for (char ch: CONSONANTS_RU){
            if(ch == firstChar) return true;
        }

        return false;
    }
}