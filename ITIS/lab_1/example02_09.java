import java.util.Scanner;

class example02_09 {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter a name: ");
String name = sc.nextLine();

System.out.println("Enter age:");
int age = sc.nextInt();

System.out.printf("Entered name is %s, age is %d\n", name, age);
sc.close();
}}
