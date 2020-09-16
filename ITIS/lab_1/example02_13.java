import java.util.Calendar;
import java.util.Scanner;

class example02_13 {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);


System.out.print("Enter your name: ");
String name = sc.nextLine();

System.out.print("Enter your birth year: ");
int birthYear = sc.nextInt();

int currentYear = Calendar.getInstance().get(Calendar.YEAR);

System.out.printf("Your name is %s, age is %d years\n", name, currentYear-birthYear);
sc.close();
}}
