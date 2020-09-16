class example02_03 {

public static void main(String[] args) {

int s = 10, d = 20;

if (s < d) {
	System.out.println("s < d");
}

s *= 2;
if (s == d) {
	System.out.println("s == d");
}

s *= d;
if (s > d) {
        System.out.println("s > d");
}

}}
