/**
 * 3. Напишите программу, в которой создается двумерный массив,
 * который выводи прямоугольник из цифр 2;
 */
public class ex_03 {

    public static void main(String[] args) {

        int rows = 10;
        int cols = 20;

        char[][] chars = new char[rows][cols];

        //заполняем массив символами
        for (int i = 0 ; i < rows; i++){
            for (int j = 0; j < cols; j++){ chars[i][j] = '2'; }
        }

        //вывод заполненного массива
        for(char[] chColumn : chars) {

            for(char ch : chColumn) { System.out.print(ch); }

            System.out.println();
        }
    }
}
