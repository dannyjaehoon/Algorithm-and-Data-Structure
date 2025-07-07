package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        /*
        - Maintain a window (`left` to `right`) such that the substring has all unique characters.
        - Expand `right` by iterating through characters.
        - If a duplicate is found, **shrink from the left** until it’s unique again.

        Time complexity is o(n)
        Space complexity is o(n)
        */

        int longestSubstring = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;

        for(int right = 0; right<s.length(); right++) {
            char c = s.charAt(right);
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            longestSubstring = Math.max(longestSubstring, right-left + 1);
        }
        return longestSubstring;
    }
}
