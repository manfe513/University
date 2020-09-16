import java.util.Scanner;

class dz1 {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter your surname: ");
String surname = sc.nextLine();

System.out.print("Enter your name: ");
String name = sc.nextLine();

System.out.print("Enter your patronymic: ");
String patronymic = sc.nextLine();

System.out.printf("Hallo %s, %s, %s\n", surname, name, patronymic);


sc.close();
}}
