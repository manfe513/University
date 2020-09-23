package com.lab2;

public class example4 {

    public static void main(String[] args) {

        int num = Helper.readNum();

        if(num > 5 && num <= 10) {
            System.out.println("Число в диапазоне от 5 (не включая 5) до 10 включительно");
        } else {
            System.out.println("Число в ВНЕ диапазона от 5 (не включая 5) до 10 включительно");
        }
    }
}