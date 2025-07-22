package medium;

public class RemoveNthNodeFromEndofList {
    int count = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        helper(dummy, n);

        return dummy.next;
    }

    private ListNode helper(ListNode head, int n) {
        if(head == null) return null;

        ListNode next = helper(head.next, n);
        count++;

        if(count == n + 1) {
            if(head != null) head.next = next.next;
            else head.next = null;
        }

        return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
