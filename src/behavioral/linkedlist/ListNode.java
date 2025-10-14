package behavioral.linkedlist;

public class ListNode {
    Integer val;
    ListNode next;

    public ListNode(Integer val) {
        this.val = val;
    }

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
