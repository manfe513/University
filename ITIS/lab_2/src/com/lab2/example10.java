package com.lab2;

public class example10 {

    public static void main(String[] args) {

        String numStr = Helper.readLine("Введите число: ");

        char numCh = numStr.charAt(numStr.length() -2);
        int num_base_10 = Character.getNumericValue(numCh);

        System.out.println("Число в 10 системе счисления = " + num_base_10);

        if(num_base_10 >= 0 && num_base_10 <= 7) {
            System.out.println("Число в диапазоне от 5 до 7 включительно");
        } else {
            System.out.println("Число НЕ в диапазоне от 5 до 7 включительно");
        }
    }
}