/**
 * 3. Напишите программу с классом, у которого есть два целочисленных поля.
 * В классе должны быть описаны конструкторы, позволяющие создавать
 * объекты без передачи аргументов, с передачей одного аргумента и с передачей
 * двух аргументов.
 */

public class ex_03 {

    public static void main(String[] args) {

        Sample_03 sample = new Sample_03();
        sample.printNums();

        sample = new Sample_03(5);
        sample.printNums();

        sample = new Sample_03(5, 10);
        sample.printNums();
    }
}

class Sample_03 {

    private int num_1;
    private int num_2;

    Sample_03() {
        System.out.println("Sample_03() констсруктор вызван");
    }

    Sample_03(int num_1) {
        System.out.println("Sample_03(int num_1) констсруктор вызван");

        this.num_1 = num_1;
    }

    Sample_03(int num_1, int num_2) {
        System.out.println("Sample_03(int num_1, int num_2) констсруктор вызван");

        this.num_1 = num_1;
        this.num_2 = num_2;
    }

    void printNums() {
        System.out.println("num_1 = " + num_1);
        System.out.println("num_2 = " + num_2);
    }
}


