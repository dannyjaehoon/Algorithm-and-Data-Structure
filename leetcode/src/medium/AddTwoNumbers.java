package medium;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode startNode = new ListNode(0);
        ListNode currNode = startNode;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int v1 = l1 !=null ? l1.val : 0;
            int v2 = l2 !=null ? l2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum /10;

            currNode.next = new ListNode(sum % 10);
            currNode = currNode.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return startNode.next;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
