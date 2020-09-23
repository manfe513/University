package com.lab2;

public class example2 {

    public static void main(String[] args) {

        int num = Helper.readNum();

        if(num % 5 == 2) {
            System.out.println("При делении на 5 в остатке получается 2");
        } else {
            System.out.println("При делении на 5 в остатке НЕ получается 2");
        }

        if(num % 7 == 1) {
            System.out.println("При делении на 7 в остатке получается 1");
        } else {
            System.out.println("При делении на 7 в остатке НЕ получается 1");
        }
    }
}