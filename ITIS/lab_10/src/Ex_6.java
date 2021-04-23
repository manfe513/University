import java.io.*;
import java.util.Scanner;

/**
 * Чтение из одного файла и запись в другой файл дан- ных посимвольно.
 */
public class Ex_6 {

    public static void main(String[] args) {

        Reader in = null; // можно сразу записать FileReader in=null;
        Writer out = null; // можно сразу записать FileWriter out =null;

        try {
            in = new FileReader("ex6-file1.txt"); // файл для чтения
            out = new FileWriter("ex6-file2.txt", true);

            // Данные считываются и записываются побайтно, как и для // InputStream/OutputStream
            int oneByte; // переменная, в которую считываются данные

            while ((oneByte = in.read()) != -1) {
                // out.write((char)oneByte); // запись с уничтожением ранее существующих данных
                out.append((char) oneByte); // запись с добавлением данных в конец
                System.out.print((char) oneByte);
            }
        } catch (IOException e) {
            System.out.println("Ошибка!!!! ");

        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException igonre) {}
        }
    }
}