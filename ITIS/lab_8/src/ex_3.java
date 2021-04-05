import java.util.ArrayList;
import java.util.Scanner;

/**
 * 3. Создать приложение, позволяющее ввести и вывести
 * одномерный массив целых чисел. Для ввода и вывода массива
 * разработать рекурсивные методы вместо циклов for.
 */

public class ex_3 {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Для наглядности предлагается вводить числа:
     * 1
     * 2
     * 3
     * -1
     */
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        create(1, head);
        print(head);

        head = new Solution().reverseBetween(head, 2, 4);
        print(head);
    }

    private static void create(int i, ListNode head) {
        while(i <= 5) {
            head.next = new ListNode(++i, null);
            head = head.next;
        }
    }


    private static void print(ListNode head) {

        while(head != null) {
            System.out.println(head.val + " -> ");
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode beforeChain = null;
        ListNode chainStart = head;
        ListNode chainEnd = null;
        ListNode afterChain = null;
        ListNode tmpCur = null;

        int counter = 1;

        // 0 -> 1(beforeChain) | -> 2(chainStart) -> 3 -> 4(chainEnd) -> | 5(afterChain) -> NULL
        while (counter < m && chainStart.next != null) {

            tmpCur = chainStart;
            chainStart = chainStart.next;
            beforeChain = tmpCur;
            counter++;
        }

        counter = m;
        chainEnd = chainStart;

        ListNode prev = null;
        ListNode next = null;


        // (2) -> 3 -> (4) -> 5
        while (counter < n && chainEnd.next != null) {

            next = chainEnd.next;
            chainEnd.next = prev;

            tmpCur = chainEnd;
            chainEnd = next;
            prev = tmpCur;
            counter++;
        }

        afterChain = next;

        beforeChain.next = chainStart;
        chainEnd.next = afterChain;

        return head;
    }
}
