package medium;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // 1. use a pq to automatically sort when a value is added
        // 2. loop through the nums and add a value from the nums array
        //    - while adding values if pq.size() > k, poll data.
        // 3. return the peek(top) of the pq.

        // [3,2,1,5,6,4], k = 2
        // 3
        // 2 3
        // 1 2 3 -> pq.size()(3) > k(2) -> 2 3
        // 2 3 5 -> pq.size()(3) > k(2) -> 3 5
        // 3 5 6 -> pq.size()(3) > k(2) -> 5 6
        // 4 5 6 -> pq.size()(3) > k(2) -> 5 6
        // return pq.peek() -> 5

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
