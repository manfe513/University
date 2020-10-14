/**
 * 2. Напишите программу, которая выводит в консольное окно
 * прямоугольный треугольник;
 */
public class ex_02 {

    public static void main(String[] args) {

        int rows = 10;

        for (int i = 1 ; i <= rows; i++){

            for (int j = 1; j < i+1; j++){ System.out.print("+"); }
            System.out.println();
        }
    }
}
