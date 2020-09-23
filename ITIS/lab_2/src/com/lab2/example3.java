package com.lab2;

public class example3 {

    public static void main(String[] args) {

        int num = Helper.readNum();

        if(num < 10) {
            System.out.println("Число < 10");
            return;
        }

        if(num % 4 == 0) {
            System.out.println("Число делится на 4");
        } else {
            System.out.println("Число НЕ делится на 4");
        }
    }
}