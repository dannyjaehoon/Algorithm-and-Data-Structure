package easy;

public class MaximumSubarray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // firstPointer indicates the last el of nums1 = 6
        // secondPointer indicates the last el of nums2 = 3
        // 4 5 6 0 0 0
        // 1 2 3

        // compare 6 > 3
        // move 6 to the last index of nums1
        // move the firstPointer to the left = 5
        // 4 5 0 0 0 6
        // 1 2 3

        // compare 5 > 3
        // move 5 to the second last index of nums1
        // move the firstPointer to the left = 4
        // 4 0 0 0 5 6
        // 1 2 3

        // compare 4 > 3
        // when firstPointer == 0, then add all remaining el in the nums2 to nums1

        // time-complexity - O(m + n)
        // space-complexity - o(1)

        int firstPointer = m - 1;
        int secondPointer = n - 1;
        int insertPointer = m + n - 1;

        while(firstPointer >= 0 && secondPointer>=0) {
            if(nums1[firstPointer] > nums2[secondPointer]) {
                nums1[insertPointer--] = nums1[firstPointer--];
            } else {
                nums1[insertPointer--] = nums2[secondPointer--];
            }
        }

        while(firstPointer >= 0) {
            nums1[insertPointer--] = nums1[firstPointer--];
        }

        while(secondPointer>=0) {
            nums1[insertPointer--] = nums2[secondPointer--];
        }
    }
}
