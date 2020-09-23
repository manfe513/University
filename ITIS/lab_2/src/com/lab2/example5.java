package com.lab2;

public class example5 {

    public static void main(String[] args) {

        String numStr = Helper.readLine("Введите число: ");

        String numThousandsStr = numStr.substring(0, numStr.length() - 3); //считаем с начала до (конец - 3 символа)
        int thousands = Integer.parseInt(numThousandsStr);

        System.out.println("Число тысяч в числе = " + thousands);
    }
}