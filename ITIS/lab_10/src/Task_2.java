import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Задание 2.
 * Создать проект, позволяющий из одного, предварительно созданного программными средствами файла,
 * переписать данные, соответствующие условию - в исходном файле содержится две строки в формате UTF-8 и 5 чисел типа double.
 * <p>
 * В результирующий файл переписать вторую строку и положительные числа.
 */
public class Task_2 {

    public static void main(String[] args) {

        BufferedReader in = null;
        FileWriter out = null;

        try {
            // Создание потоков
            in = new BufferedReader(
                    new InputStreamReader(new FileInputStream("task2-file1.txt"), StandardCharsets.UTF_8)
            );
            out = new FileWriter("task2-file2.txt");

            try {

                String s;

                in.readLine();
                out.write(in.readLine());

                while ((s = in.readLine()) != null) {
                    int num = Integer.valueOf(s);
                    if(num > 0) {
                        out.write("\n"+s);
                    }
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
}