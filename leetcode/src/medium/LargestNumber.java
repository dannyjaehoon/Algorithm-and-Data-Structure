package medium;

import java.util.Arrays;

public class LargestNumber {
    class Solution {
        public String largestNumber(int[] nums) {

            // Step 1: Compare "3" + "30" = "330" with "30" + "3" = "303". Since "330" is larger, "3" should come before "30".
            // → Array: [3, 30]

            // Step 2a: Compare "30" + "34" = "3034" with "34" + "30" = "3430". Since "3430" is larger, "34" comes before "30".
            // → Array: [3, 34, 30]

            // Step 2b: Now compare "3" + "34" = "334" with "34" + "3" = "343". Since "343" is larger, "34" should come before "3".
            // → Array: [34, 3, 30]

            // so on.. at the end, we will join all sorted elements from Array together to build the largest string number.


            // 1. initiate a string array with the same length as nums
            // 2. sort the array by comparing the two elements (a+b vs b+a) in decending order.
            // 3. Iterate through the sorted array and append all elements to form the largest number.
            // 4. return the resulting string

            // Time-complexity : O(nlogn)
            // Space-complexity : O(n)

            // 1. Why do we need to compare (a+b) and (b+a) instead of just looking at the first digit?
            // 2. What happens if the array contains only zeros, like [0,0,0]?
            // 3. Is there any way to solve this without converting numbers to strings?

            int n = nums.length;
            String[] strArr = new String[n];

            for(int i = 0; i<n; i++) {
                strArr[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(strArr, (a, b) -> (b+a).compareTo(a+b));
            if(strArr[0].equals("0")) return "0";

            StringBuilder sb = new StringBuilder();

            for(String s : strArr) {
                sb.append(s);
            }

            return sb.toString();
        }
    }
}
