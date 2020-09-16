import java.util.Scanner;
import java.util.Calendar;

class dz5 {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter your birth year: ");
int birthYear = sc.nextInt();

int currentYear = Calendar.getInstance().get(Calendar.YEAR);

System.out.printf("Your age is %d years\n", currentYear-birthYear);
sc.close();
}}
