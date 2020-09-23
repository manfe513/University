package com.lab2;

public class example1 {

    public static void main(String[] args) {

        int num = Helper.readNum();

        if(num % 3 == 0) {
            System.out.println("Число делится на 3");
        } else {
            System.out.println("Число НЕ делится на 3");
        }
    }
}