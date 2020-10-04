import java.util.Scanner;

public class Helper {

    private static final Scanner sc = new Scanner(System.in);

    static int readNum() {

        System.out.print("Введите число: ");
        return sc.nextInt();
    }

    static int readNum(String prompt) {

        System.out.print(prompt);
        return sc.nextInt();
    }

    static String readLine(String prompt) {

        System.out.print(prompt);
        return sc.nextLine();
    }
}
