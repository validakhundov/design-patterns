package behavioral.linkedlist;

public class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);


        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }

        ListNode pointer = node1;

        while (pointer != null) {
            System.out.println(pointer.val);
            pointer = pointer.next;
        }


    }
}

// 1, 2, 3, 4, 5
