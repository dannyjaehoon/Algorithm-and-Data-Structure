package easy;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        ListNode oneStep = head;
        ListNode twoStep = head;

        while(twoStep != null && twoStep.next != null) {

            oneStep = oneStep.next;
            twoStep = twoStep.next.next;

            if(oneStep == twoStep) return true;
        }

        return false;
    }
    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
}
