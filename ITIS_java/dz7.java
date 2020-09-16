import java.util.Calendar;
import java.util.Scanner;

class dz7 {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter your age: ");
int age = sc.nextInt();

int currentYear = Calendar.getInstance().get(Calendar.YEAR);

System.out.printf("Your birthYear is %d\n", currentYear-age);
sc.close();
}}
