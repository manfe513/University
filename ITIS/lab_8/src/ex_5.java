/**
 * 5. Создать два проекта, в которых продемонстрировать два
 * способа создания линейного однонаправленного списка (с головы и с
 * хвоста) согласно примеру 2 из второго раздела. Отработать код с
 * помощью отладчика и привести скриншоты минимум трех точек
 * обработанных отладчиком.
 *
 * 1) Наращивание списка с головы
 *
 * 2) Наращивание списка с хвоста
 */

public class ex_5 {

    public static void main(String[] args) {

        //1) Наращивание головы списка
        Node head = null;
        for(int i=10; i>0; i--) {
            head = new Node(i, head);
        }

        printLinkedList(head);

        //2) Наращивание хвоста списка
        Node head1 = new Node(1, null);
        Node tail = head1;
        for(int i=2; i<=10; i++) {
            tail.next = new Node(i, null);
            tail = tail.next;
        }

        printLinkedList(head1);
    }

    private static void printLinkedList(Node head) {

        Node ref = head;

        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }

        System.out.println();
    }
}

