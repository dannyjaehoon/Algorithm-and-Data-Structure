package medium;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node, Node> randomMap = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            randomMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while(cur != null) {
            Node copied = randomMap.get(cur);
            copied.next = randomMap.get(cur.next);
            copied.random = randomMap.get(cur.random);
            cur = cur.next;
        }

        return randomMap.get(head);
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
