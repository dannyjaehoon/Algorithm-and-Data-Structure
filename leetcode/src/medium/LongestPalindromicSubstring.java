package medium;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        // A brute-force way would be to check every possible substring and see if its a palindrome, but would tak O(n3) time and isn't efficient

        // expand around center technique
        // we expand from the center and check on character to the left and one to the right at each step to see if the substring is a palindrome

        // for each character in the string
        // i try expanding around it in two ways
        // once treating it as the center of an odd-length palidrome
        // and once as the center of an even-length palidrome

        // while expanding, I compare characters on the left and right, and stop when they dont match
        // at each step, I track the longest palindrome I have found


        int start = 0;
        int end = 0;

        for(int i = 0; i<s.length(); i++) {
            int oddLength = findLengthOfParadrome(s, i, i);
            int evenLength = findLengthOfParadrome(s, i, i +1);
            int len = Math.max(oddLength, evenLength);

            if(len > end - start) {
                start = i - (len - 1) /2;
                end = i + len / 2;
            }
        }

        // StringBuilder sb = new StringBuilder();
        // for(int i = start; i<=end; i++) {
        //     sb.append(s.charAt(i));
        // }
        return s.substring(start, end +1);
    }

    private int findLengthOfParadrome(String s, int left, int right) {
        while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
