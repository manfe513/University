/**
 * 3.
 * 0) + Напишите программу, в которой на основе суперкласса создается подкласс, а на
 * основе этого подкласса создается еще один подкласс (цепочка наследования из трех
 * классов).
 *
 * 1) + В первом суперклассе есть открытое целочисленное поле, метод с одним
 * параметром для присваивания значения полю и конструктор с одним параметром.
 *
 * 2) + Во втором классе появляется открытое символьное поле, метод с двумя параметрами для
 * присваивания значения полям (перегрузка метода из суперкласса) и конструктор с двумя
 * параметрами.
 *
 * 3) + В третьем классе появляется открытое текстовое ноле, метод с тремя
 * аргументами для присваивания значений полям (перегрузка метода из суперкласса) и
 * конструктор с тремя параметрами.
 *
 * 4) + Для каждого класса определите метод toString () так, чтобы он возвращал строку с названием класса
 * и значениями всех полей объекта.
 */

package ex_3;

public class ex_3 {

    public static void main(String[] args) {

        One one = new One(5);
        System.out.println(one);

        Two two = new Two(10, 'A');
        System.out.println(two);

        Three three = new Three(20, 'B', "some text");
        System.out.println(three);
    }
}






