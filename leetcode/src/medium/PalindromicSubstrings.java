package medium;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        // a b c
        // left = center / 2
        // right = left + center % 2;

        int count = 0;

        // since a string of length  has 2n -1 possible centers(n characters and n - 1 gaps),
        // we iterate from center = 0 to 2n - 2.

        // center / 2 give the left index
        // center % 2 tells us if the center is odd(0-> same character, 1-> between characters)

        // abc
        // center = 0:
        //   left = 0, right = 0      → center at 'a' (odd-length)
        //   check: "a" ✅

        // center = 1:
        //   left = 0, right = 1      → center between 'a' and 'b' (even-length)
        //   check: "ab" ❌

        // center = 2:
        //   left = 1, right = 1      → center at 'b'
        //   check: "b" ✅

        // center = 3:
        //   left = 1, right = 2      → center between 'b' and 'c'
        //   check: "bc" ❌

        // center = 4:
        //   left = 2, right = 2      → center at 'c'
        //   check: "c" ✅

        for(int center = 0; center < 2 * s.length() -1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}
