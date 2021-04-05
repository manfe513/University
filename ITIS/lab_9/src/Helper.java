import java.util.ArrayList;
import java.util.Scanner;

public class Helper {

    private static final Scanner sc = new Scanner(System.in);

    static int readNum() {

        System.out.print("Введите число: ");
        return sc.nextInt();
    }

    static String readLine(String prompt) {

        System.out.print(prompt);
        return sc.nextLine();
    }

    static int[] recursiveNumsInput(ArrayList<Integer> enteredNums) {

        System.out.println("Введите число >0 или -1 для выхода:");
        int num = sc.nextInt();

        if(num == -1) {
            int[] nums = new int[enteredNums.size()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = enteredNums.get(i);
            }
            return nums;
        }

        enteredNums.add(num);

        return recursiveNumsInput(enteredNums);
    }
}