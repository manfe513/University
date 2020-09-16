import java.util.Scanner;

class example02_15 {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter number1: ");
int number1 = sc.nextInt();

System.out.print("Enter number2: ");
int number2 = sc.nextInt();

System.out.printf("Sum = %d\n", number1+number2);
sc.close();
}}
