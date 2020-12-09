import java.util.ArrayList;

/**
 * Вариант 2: Ввести с клавиатуры список из n целых чисел.
 * <p>
 * а) Найти сумму, количество и среднее значение среди чисел, которые не делятся на 5.
 * <p>
 * б) Найти среди отрицательных чисел, которые не делятся на 5,
 * минимальное и максимальное значения и их номера и поменять их местами.
 */

public class ex_7_additional {

    public static void main(String[] args) {

        ArrayList<Integer> nums = Helper.recursiveNumsInput(new ArrayList<>());

        System.out.println("Числа, которые не делятся на 5:");
        ArrayList<Integer> numsThatCantDivideBy_5 = getNumsThatCantDivideBy_5(nums);

        if (numsThatCantDivideBy_5.isEmpty()) {
            System.out.println("Входной набор данных не содержит искомых чисел");
            return;
        }

        //выывод списка для информативности
        printRecursive(numsThatCantDivideBy_5);

        appendixA(numsThatCantDivideBy_5);
        appendixB(nums);
    }

    /**
     * а) Найти сумму, количество и среднее значение среди чисел, которые не делятся на 5.
     */
    private static void appendixA(ArrayList<Integer> numsThatCantDivideBy_5) {

        int sum = 0;
        int count = numsThatCantDivideBy_5.size();

        for (int num : numsThatCantDivideBy_5) {
            sum += num;
        }

        int averageValue = sum / count;

        System.out.println("Сумма чисел = " + sum);
        System.out.println("Количество чисел = " + count);
        System.out.println("Среднее значение чисел = " + averageValue);
    }

    /**
     * б) Найти среди отрицательных чисел, которые не делятся на 5,
     * * минимальное и максимальное значения и их номера и поменять их местами.
     */
    private static void appendixB(ArrayList<Integer> numsThatCantDivideBy_5) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < numsThatCantDivideBy_5.size(); i++) {

            int num = numsThatCantDivideBy_5.get(i);

            if (num < min) {
                min = num;
                minIndex = i;
            }

            if (num > max) {
                max = num;
                maxIndex = i;
            }
        }

        if(minIndex != -1 && maxIndex != -1) {
            numsThatCantDivideBy_5.set(minIndex, max);
            numsThatCantDivideBy_5.set(maxIndex, min);

            System.out.println("Список, с взаимоизменёнными мин и макс элементами:");
            printRecursive(numsThatCantDivideBy_5);

        } else {
            System.out.println("В списке отсутствуют минимум или максимум");
        }
    }

    private static ArrayList<Integer> getNumsThatCantDivideBy_5(ArrayList<Integer> nums) {
        ArrayList<Integer> numsThatCantDivideBy_5 = new ArrayList<>();

        for (int num : nums) {
            if (num % 5 != 0) numsThatCantDivideBy_5.add(num);
        }

        return numsThatCantDivideBy_5;
    }

    private static void printRecursive(ArrayList<Integer> nums) {

        if (nums.size() == 0) {
            System.out.println();
            return;
        }

        ArrayList<Integer> newList = new ArrayList<>(nums);

        int num = newList.remove(0);
        System.out.print(num + " ");

        printRecursive(newList);
    }
}
