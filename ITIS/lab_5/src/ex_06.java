/**
 * 6. Напишите программу с классом, в котором есть два закрытых
 * целочисленных поля (назовем их max и min).
 *
 * 1) Значение поля max не может быть меньше значения поля min.
 * 2) Значения полям присваиваются с помощью открытого метода.
 * 3) Метод может вызываться с одним или двумя елочисленными аргументами.
 * При вызове метода значения полям присваиваются так:
 * - сравниваются текущие значения полей и значения аргументов, переданных методу. Самое большое из значений присваивается
 * полю max, а самое маленькое из значений присваивается полю min.
 *
 *
 * 4) Предусмотрите конструктор, который работает по тому же принципу, что и
 * метод для присваивания значений полям. В классе также должен быть метод,
 * отображающий в консольном окне значения полей объекта.
 */

public class ex_06 {

    public static void main(String[] args) {

        //передаём значение через конструктор => min=1, max=2
        Sample_06 sample = new Sample_06(1, 2);
        sample.print();

        //значение должно проставитьсся => min=1, max=5
        sample.setNums(5);
        sample.print();

        //превысили допустимое значение => min=9, max=11
        sample.setNums(11, 9);
        sample.print();
    }
}

class Sample_06 {

    private int min;
    private int max;

    Sample_06(int num_1, int num_2) {
        System.out.println("Sample_06(int num_1, int num_2) констсруктор вызван");

        this.setNums(num_1, num_2);
    }

    void setNums(int num_1, int num_2) {
        this.min = Math.min(num_1, num_2);
        this.max = Math.max(num_1, num_2);
    }

    void setNums(int num) {
        this.min = Math.min(this.min, num);
        this.max = Math.max(this.max, num);
    }

    void print() {
        System.out.printf("min = %d, max = %d\n", min, max);
    }
}


