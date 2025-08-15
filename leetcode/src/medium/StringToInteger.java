package medium;

public class StringToInteger {
    // Time Complexity: O(n)
// Space Complexity: O(1)

// Description:
// - Skip leading whitespace
// - Handle optional '+' or '-' sign
// - Parse digit characters and construct the number
// - Clamp the result to Integer.MAX_VALUE or Integer.MIN_VALUE on overflow
// - Return 0 if no valid conversion can be performed

// Example Inputs:
// "42"             → 42
// "   -42"         → -42
// "4193 with text" → 4193
// "words and 987"  → 0
// "-91283472332"   → -2147483648 (clamped)

// Interview Questions:
// 1. What is the difference between using `long` to detect overflow and checking for overflow during accumulation?
// 2. How would your solution handle unexpected characters like emojis, currency symbols, or non-ASCII text?
// 3. Would your solution behave differently for input '+-12' or '--123'?

    class Solution {
        public int myAtoi(String s) {
            int i = 0;
            int n = s.length();

            // 1. Skip leading whitespace
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }

            // 2. Check if string is empty after removing spaces
            if (i == n) return 0;

            // 3. Handle sign
            boolean isNegative = false;
            if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                isNegative = s.charAt(i) == '-';
                i++;
            }

            // 4. Parse digits
            long result = 0;
            while (i < n && Character.isDigit(s.charAt(i))) {
                result = result * 10 + (s.charAt(i) - '0');

                // 5. Clamp during calculation to avoid overflow
                if (!isNegative && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (isNegative && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

                i++;
            }

            return isNegative ? (int) - result : (int) result ;
        }
    }
}
