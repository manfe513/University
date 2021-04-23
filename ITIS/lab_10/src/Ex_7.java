import java.io.*;

/**
 * Пример 7.
 * Чтение из одного файла и запись в другой файл данных построчно с использованием буфера в 1 килобайт.
 */
public class Ex_7 {

    private static short BUFFER_SIZE = 1024;

    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter out = null;

        try {
            br = new BufferedReader(new FileReader("ex7-file1.txt"), BUFFER_SIZE);
            out = new BufferedWriter(new FileWriter("ex7-file2.txt"));

            int lineCount = 0;
            String s;

            while((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount+":"+s);
                out.write(s);
                out.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (br != null) br.close();
                if (out != null) out.close();
            } catch (IOException ignore) {  }
        }
    }
}