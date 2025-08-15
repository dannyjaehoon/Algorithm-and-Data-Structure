package medium;

import java.util.*;

public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            // I group anagrams by a canonical key: the sorted characters.
            // For each string, I sort its chars (O(k log k)), use the sorted string as the map key, and append the original to that bucket.
            // At the end I return all buckets.

            // Time-complexity : O(n * k log k) for n strings of avg length k,
            // Space-complexity : O(n * k).

            // 1. Why does using the sorted string as the key correctly group anagrams?
            // 2. How would you guarantee stable group order and defined order within each group (e.g., LinkedHashMap, sorting buckets)?
            // 3. If anagrams are case-insensitive and ignore spaces/punctuation, what preprocessing and key construction changes would you make?


            Map<String, List<String>> strsMap = new HashMap<>();

            for(String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String newStr = new String(chars);

                strsMap.putIfAbsent(newStr, new ArrayList<>());
                strsMap.get(newStr).add(str);
            }
            List<List<String>> res = new ArrayList<>();
            for(Map.Entry<String, List<String>> entry : strsMap.entrySet()) {
                res.add(entry.getValue());
            }

            return res;
        }
    }
}
