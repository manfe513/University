import java.util.Scanner;

class example5 {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter your name: ");
String name = sc.nextLine();

System.out.print("Enter your age: ");
int age = sc.nextInt();

System.out.print("Enter your height: ");
float height = sc.nextFloat();

System.out.printf("So, your: name = %s, age = %d, height = %.2f\n", name, age, height);

sc.close();
}}
