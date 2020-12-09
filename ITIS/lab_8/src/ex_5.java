/**
 * 4. Выполнить пример 1 из раздела 2. Отработать код с помощью
 * отладчика и привести скриншоты минимум трех точек обработанных
 * отладчиком.
 */

public class ex_5 {

    public static void main(String[] args) {

        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node ref = node1;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
    }
}

