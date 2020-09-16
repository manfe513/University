import java.util.Scanner;

class example02_20 {

//(y=exp(b*log(a));
private static double pow(double a, double b) {

    return Math.pow(a, b);
}

private static double hyp(double a, double b) {

    return Math.sqrt(pow(a, 2) + pow(b, 2));
}

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

System.out.print("katet a: ");
double a = sc.nextDouble();

System.out.print("katet b: ");
double b = sc.nextDouble();

System.out.println("hypotenuse = " + hyp(a, b));

}}
