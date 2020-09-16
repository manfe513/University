import java.util.Scanner;

class example02_16 {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter number: ");
int number0 = sc.nextInt();

int numberLower = number0 - 1;
int numberUpper = number0 + 1;

long resultingPow = Math.round(
        Math.pow(number0+numberLower+numberUpper, 2)
);

System.out.printf("Entered = %d\nLower = %d\nUpper = %d\nPoweredSum = %d\n",
        number0,
        numberLower,
        numberUpper,
        resultingPow
);

sc.close();
}}
