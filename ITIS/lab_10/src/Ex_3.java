import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Ex_3 {

    public static void readAllByArray(InputStream in) throws IOException {

        byte[] buff = new byte[5];

        while(true) {
            int count = in.read(buff);
            if(count != -1) {
                System.out.println(
                        "количество = " + count +
                                "buff = " + Arrays.toString(buff) +
                                "str = " + new String(buff, 0 , count, Charset.forName("UTF-8")
                        )
                );
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {

        InputStream inFile = null;

        try {
            inFile = new FileInputStream(new File("sample.txt"));
            readAllByArray(inFile);
            inFile.close();
            System.out.println("\n\n\n");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка: " + e);

        } finally {
            if (inFile != null) {
                try {
                    inFile.close();
                } catch (IOException ignore) {}
            }
        }

    }
}
