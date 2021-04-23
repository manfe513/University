import java.io.*;

/**
 * Пример 10.
 * Выполнить чтение из одного файла и запись в дру- гой файл с использованием класса PrintWriter.
 */
public class Ex_10 {

    public static void main(String[] args) {

        BufferedReader br = null;
        PrintWriter out = null;

        try {
            // Создание потоков
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("ex10-file1.txt"), "cp1251"
                    )
            );

            out = new PrintWriter("ex10-file2.txt", "cp1251"); // Переписывание информации из одного файла в другой

            int lineCount = 0;
            String s;

            while ((s = br.readLine()) != null) {
                lineCount++;
                out.println(lineCount + ": " + s);
            }

        } catch (IOException e) {
            System.out.println("Ошибка !!!!!!!!");

        } finally {
            try {
                br.close();
                out.flush();
                out.close();
            } catch (IOException ignore) {}
        }
    }
}