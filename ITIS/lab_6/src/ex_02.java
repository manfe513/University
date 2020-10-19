/**
 * 2. Напишите программу с классом, в котором есть закрытое статическое целочисленное ноле
 * с начальным нулевым значением.
 *
 * В классе должен быть описан статический метод,
 * при вызове которого отображается текущее значение статического поля,
 * после чего значение поля увеличивается на единицу.
 */
public class ex_02 {

    private static int num = 0;

    public static void main(String[] args) {

        printAndIncrementNum();
        printAndIncrementNum();
        printAndIncrementNum();
    }

    private static void printAndIncrementNum() {
        System.out.println("Current num value = " + num++);
    }
}
