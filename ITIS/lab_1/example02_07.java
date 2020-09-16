import java.util.Scanner;

class example02_07 {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter the circle RADIUS: ");
int radius = sc.nextInt();

double area = Math.PI * Math.pow(radius, 2);

System.out.printf("Circle area with a radius %d = %.2f \n", radius, area);
sc.close();
}}
