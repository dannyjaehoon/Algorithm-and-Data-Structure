package medium;

import java.util.*;

public class InsertDeleteGetRandomO1 {
    /*
    Problem: Design a data structure that supports insert, remove, and getRandom operations in average O(1) time.

    Approach:
    - Use a HashMap and ArrayList to achieve O(1) operations.
        - HashMap stores the value and its index in the list.
        - ArrayList stores the actual values to support O(1) access and random retrieval.
    - On insert:
        - Check if value exists in the map. If not, add it to the end of the list and update the map.
    - On remove:
        - Swap the target value with the last element in the list to maintain index integrity.
        - Update the map accordingly and remove the last element in O(1) time.
    - On getRandom:
        - Use Random.nextInt() to return a random element from the list.

    Time Complexity:
    - insert: O(1)
    - remove: O(1)
    - getRandom: O(1)

    Space Complexity:
    - O(n), where n is the number of elements stored.

    Sample Interview Questions:
    1. Why do we need to use both a HashMap and an ArrayList?
    2. What happens if we don’t swap the value with the last element on remove?
    3. How does getRandom guarantee uniform randomness?

    */

    class RandomizedSet {
        Map<Integer, Integer> map; // key: element, value: index in list
        List<Integer> list;
        Random random = new Random();

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;

            int size = list.size();
            map.put(val, size);
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;

            int idx = map.get(val);
            int last = list.get(list.size() - 1);

            // Swap with last element to maintain O(1) deletion
            list.set(idx, last);
            map.put(last, idx);

            // Remove val from map and list
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            int randomInd = random.nextInt(list.size());
            return list.get(randomInd);
        }
    }
}
