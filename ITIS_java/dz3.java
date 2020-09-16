import java.util.Scanner;

class dz3 {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter day name: ");
String dayName = sc.nextLine();

System.out.print("Enter month name: ");
String monthName = sc.nextLine();

System.out.print("Enter a date: ");
int date = sc.nextInt();

System.out.printf("Current date: %s %d %s\n", dayName, date, monthName);
sc.close();
}}
