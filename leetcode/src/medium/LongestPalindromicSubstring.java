package medium;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        // A brute-force way would be to check every possible substring and see if its a palindrome, but would take O(n^3) time and isn't efficient

        // expand around center technique
        // we expand from the center and check one character to the left and one to the right at each step to see if the substring is a palindrome

        // for each character in the string
        // I try expanding around it in two ways
        // once treating it as the center of an odd-length palindrome
        // and once as the center of an even-length palindrome

        // while expanding, I compare characters on the left and right, and stop when they don't match
        // at each step, I track the longest palindrome I have found

        // i = 0 (b)
        // (0,0) Match (b == b), return right(1) - left(-1) -1 = 1
        // (0,1) Match (b != a), return right(1) - left(0) -1 = 0
        // len = 1, start = 0, end = 0

        // i = 1 (a)
        // (1,1) match (a == a) -> (0,2) match (b == b) -> (-1,3), return 3 - (-1) -1 = 3
        // (1,2) match (a != b), return 2 - 1 - 1 = 0
        // len = 3, start = 0, end = 2

        // i = 2 (b)
        // (2,2) match (b == b) -> (1,3) match (a == a) -> (0,4) match (b != d), return 4 - 0 - 1 = 3
        // (2,3) match (b != a), return 0
        // len = 3

        // i = 3 (a)
        // (3,3) match (a == a) -> (2,4) match (b != d), return 1
        // (3,4) match (a != d) return 0
        // len = 1

        // i = 4 (d)
        // (4,4) match (d == d) -> (3,5) out of scope, return 5 - 3 - 1 = 1
        // (4,5) out of scope, return 5 - 4 - 1 = 0

        // time-complexity : O(n^2)
        // space-complexity : O(1)

        // 1. Why do we need to check both odd and even centers when expanding?
        // 2. How does the formula start = i - (len - 1) / 2 and end = i + len / 2 correctly compute the substring boundaries for both odd and even lengths?
        // 3. Why do we subtract 1 in right - left - 1 when calculating the palindrome length?



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
