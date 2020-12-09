/**
 * 6. Разработать проект, в котором для ввода, вывода и изменения
 * односвязного линейного списка создать следующие методы:
 * <p>
 * а) с использованием цикла:
 * + ввод с головы createHead();
 * + ввод с хвоста createTail();
 * + вывод (возвращается строка, сформированная из элементов списка) toString();
 * + добавление элемента в начало списка AddFirst();
 * + добавление элемента в конец списка AddLast();
 * + вставка элемента в список с указанным номером Insert();
 * + удаление элемента с головы списка RemoveFirst();
 * + удаление последнего элемента списка RemoveLast();
 * + удаление из списка элемента с указанным номером Remove();
 * <p>
 * б) с использованием рекурсии:
 * + ввод с головы createHeadRec();
 * + ввод с хвоста createTailRec();
 * – вывод (возвращается строка, сформированная из элементов
 * списка) toStringRec().
 */

public class ex_6 {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        System.out.println("Наращивание головы:");
        list.createFromHead(new int[]{3, 2, 1});
        list.printLinkedList();

        System.out.println("Наращивание хвоста");
        list.createFromTail(new int[]{4, 5, 6});
        list.printLinkedList();

        System.out.println("добавление элемента в начало и конец списка:");
        list.createFromHead(new int[]{3, 2, 1});
        list.printLinkedList();
        list.addFirst(new Node(-1, null));
        list.addLast(new Node(11, null));
        list.printLinkedList();

        System.out.println("добавление элемента '-1' по индексу 1:");
        list.createFromTail(new int[]{1,2,3});
        list.printLinkedList();
        list.insert(1, new Node(-1, null));
        list.printLinkedList();

        System.out.println("удаление первого и последнего элементов:");
        list.createFromTail(new int[]{1,2,3,4,5});
        list.printLinkedList();
        list.removeFirst();
        list.removeLast();
        list.printLinkedList();

        System.out.println("удаление элемента по значению:");
        list.createFromTail(new int[]{1,2,3,4,5});
        list.printLinkedList();
        list.remove(3);
        list.printLinkedList();

        System.out.println("Наращивание головы, рекурсивно:");
        list.createFromHeadRecursive(new int[]{5,4,3,2,1});
        list.printLinkedList();

        System.out.println("Наращивание хвоста, рекурсивно:");
        list.createFromTailRecursive(new int[]{5,4,3,2,1});
        list.printLinkedList();

        System.out.println("Вывод рекурсивно, исходный список:");
        list.createFromTailRecursive(new int[]{5,4,3,2,1});
        list.printLinkedList();
        System.out.println("Рекурсивный вывод:\n" + list.toStringRecursive());
    }
}

class MyLinkedList {

    private Node head = null;
    private Node tail = null;

    void createFromHead(int[] values) {
        head = new Node(values[0], null);
        tail = head;

        for (int i = 1; i < values.length; i++) {
            head = new Node(values[i], head);
        }
    }

    void createFromHeadRecursive(int[] values) {
        head = new Node(values[0], null);
        tail = head;

        addItemsFromHeadRecursive(subArray(values, 1));
    }

    private int[] subArray(int[] arr, int fromIndex) {

        int[] newArr = new int[arr.length-fromIndex];

        for(int i=0; i< newArr.length; i++) {
            newArr[i] = arr[i+1];
        }

        return newArr;
    }

    private void addItemsFromHeadRecursive(int[] values) {
        if(values.length == 0) return;

        head = new Node(values[0], head);

        addItemsFromHeadRecursive(subArray(values, 1));
    }

    void createFromTail(int[] values) {
        head = new Node(values[0], null);
        tail = head;

        for (int i = 1; i < values.length; i++) {
            tail.next = new Node(values[i], null);
            tail = tail.next;
        }
    }

    void createFromTailRecursive(int[] values) {
        head = new Node(values[0], null);
        tail = head;

        addItemsFromTailRecursive(subArray(values, 1));
    }

    private void addItemsFromTailRecursive(int[] values) {
        if(values.length == 0) return;

        tail.next = new Node(values[0], null);
        tail = tail.next;

        addItemsFromTailRecursive(subArray(values, 1));
    }

    void printLinkedList() {
        System.out.println(toString());
    }

    void addFirst(Node node) {
        node.next = head;
        head = node;
    }

    void addLast(Node node) {
        tail.next = node;
        tail = node;
    }

    void insert(int index, Node node) {

        Node ref = head;
        while (ref != null) {

            if (ref.value == index) {
                node.next = ref.next;
                ref.next = node;
                break;
            }
            ref = ref.next;
        }
    }

    void removeFirst() {
        head = head.next;
    }

    void removeLast() {

        Node ref = head;

        while (ref.next.next != null) {
            ref = ref.next;
        }

        ref.next = null;
        tail = ref;
    }

    void remove(int value) {

        Node ref = head;

        while (ref.next.value != value) ref = ref.next;

        ref.next = ref.next.next;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Node ref = head;

        while (ref != null) {
            sb.append(ref.value);
            sb.append(" ");
            ref = ref.next;
        }

        return sb.toString();
    }

    String toStringRecursive() {

        return toStringRecursiveInternal(head);
    }

    private String toStringRecursiveInternal(Node current) {

        if(current == null) return "";

        return current.value + " " + toStringRecursiveInternal(current.next);
    }
}

