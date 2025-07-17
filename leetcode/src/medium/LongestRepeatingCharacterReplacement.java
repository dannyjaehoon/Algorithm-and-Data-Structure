package medium;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {

        // 1. use a sliding window to explore substring
        // 2. within each window, count character frequencies
        // 3. try to keep the most frequent character fixed, and see if we can change the rest ( at most k)
        // 4. if the window becomes invalid(too many replacements needed), shrink the windwo from the left

        // windowSize - maxCharCount <= k
        // windowSize = right - left + 1
        // maxCharCount = count of the most frequent character in the current window
        // if this difference exceeds k, it means we need to replace more than k characters, so we shrink the window.

        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;

        for(int right = 0; right <s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            int windowSize = right - left + 1;

            if(windowSize - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
