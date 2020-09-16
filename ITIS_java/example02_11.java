import java.util.Scanner;

class example02_11 {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter month name: ");
String monthName = sc.nextLine();

System.out.print("Enter days count: ");
int daysCount = sc.nextInt();

System.out.printf("Month %s consists of %d days\n", monthName, daysCount);
sc.close();
}}
