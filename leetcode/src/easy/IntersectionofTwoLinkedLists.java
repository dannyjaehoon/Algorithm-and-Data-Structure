package easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>();

        while(headA != null) {
            setA.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if(setA.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
}
