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

    static void skip() {
        sc.next();
    }

    static int[] recursivePositiveNumsInput(ArrayList<Integer> inputNums) {
        if(inputNums == null) {
            inputNums = new ArrayList<>();
        }

        System.out.println("Введите число >0 или -1 для выхода:");
        int num = sc.nextInt();

        if(num == -1) {
            int[] nums = new int[inputNums.size()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = inputNums.get(i);
            }
            return nums;
        }

        inputNums.add(num);

        return recursivePositiveNumsInput(inputNums);
    }

    static int[] recursiveNumsInput(int size, ArrayList<Integer> inputNums) {
        if(inputNums == null) {
            inputNums = new ArrayList<>();
        }

        System.out.println("Введите число:");
        int num = sc.nextInt();

        inputNums.add(num);

        if(inputNums.size() == size) {
            int[] nums = new int[inputNums.size()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = inputNums.get(i);
            }
            return nums;
        }

        return recursiveNumsInput(size, inputNums);
    }
}