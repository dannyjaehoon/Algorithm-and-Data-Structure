package medium;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        // nums[mid] < nums[mid + 1] -> peak is on the right side
        // nums[mid] > nums[mid + 1] -> peak is on the left size

        // left = 0;
        // right = n - 1 = 6
        // while(left < right)
        // [1,2,1,3,5,6,4]

        // int mid = 0 + (6 + 0) / 2 = 3
        // if(nums[mid](3) < nums[mid + 1](5)) left = mid + 1 = 4;

        // int mid = 4 + (6 - 4) / 2 = 5
        // if(nums[mid](5) < nums[mid+1](6)) left = mid + 1 = 6

        // break while loop (left == right)
        // return left;

        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while(left < right) {
            int mid = left + (right - left) /2;
            if(nums[mid] < nums[mid+1]) left = mid + 1;
            else right = mid;
        }
        return left;

    }
}
