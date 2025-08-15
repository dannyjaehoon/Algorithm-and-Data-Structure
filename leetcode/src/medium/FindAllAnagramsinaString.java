package medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            // I use a fixed-size sliding window of length p.length() and maintain a frequency array for the remaining needed characters
            // I also keep a count variable to track how many characters are still needed to form an anagram.

            // step by step logic
            // create an array charCount[26] with the frequency of each character in p
            // and set count = p.length()

            // when I add a character at right, I decrement its count in charCount
            // if (charCount[c] >= 1), I decrease count;

            // if count becomes zero, it means the current window contains exactly all needed characters, store left index to the result list.

            // if the window size equals p.length(), I remove the character at left
            // I increment its count back in charCount
            // if charCount[c] >= 0, I increment count because we now miss that character again

            // continue until right reaches the end of s.

            // Time-complexity :  O(n + m)
            // space-complexity : O(1)

            // 1. How does your solution handle characters that are not in p?
            // 2. What changes would you make if the input strings could contain any Unicode characters instead of only lowercase English letters?
            // 3. Why does decrementing and incrementing the frequency array without extra checks still work correctly?

            List<Integer> result = new ArrayList();
            if (s == null || s.length() == 0) return result;

            int[] char_count = new int[26];
            for (char c : p.toCharArray()) {
                char_count[c - 'a']++;
            }

            int left = 0;
            int right = 0;
            int count = p.length();

            while (right < s.length()) {
                if (char_count[s.charAt(right++) - 'a']-- >= 1) count--;

                if (count == 0) result.add(left);

                if (right - left == p.length() && char_count[s.charAt(left++) - 'a']++ >= 0) count++;
            }

            return result;
        }
    }
}
