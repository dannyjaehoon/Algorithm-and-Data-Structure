package hard;

import java.util.PriorityQueue;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i <lists.length; i++) {
            while(lists[i] != null) {
                pq.add(lists[i].val);
                if(lists[i] != null) lists[i] = lists[i].next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(!pq.isEmpty()) {
            cur.next = new ListNode(pq.poll());
            cur = cur.next;
        }

        return dummy.next;
    }
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
