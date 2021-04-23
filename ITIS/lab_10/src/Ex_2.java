import java.io.*;
import java.net.URL;

public class Ex_2 {

    public static void readAllByByte(InputStream in) throws IOException {

        while(true) {
            int oneByte = in.read();
            if(oneByte != -1) {
                System.out.print((char) oneByte);
            } else {
                System.out.println("\n end");
                break;
            }
        }
    }

    public static void main(String[] args) {

        try {
            InputStream fileIn = new FileInputStream(new File("sample.txt"));
            readAllByByte(fileIn);
            fileIn.close();
            System.out.println("\n\n\n");

            InputStream webIn = new URL("https://www.google.com").openStream();
            readAllByByte(webIn);
            webIn.close();
            System.out.println("\n\n\n");

            InputStream byteArrIn = new ByteArrayInputStream(new byte[] {7,9,3,7,4});
            readAllByByte(byteArrIn);
            byteArrIn.close();
            System.out.println("\n\n\n");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка: " + e);
        }

    }
}
