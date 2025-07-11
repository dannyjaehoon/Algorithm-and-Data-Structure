package medium;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {

        // int n = nums.length;
        // if(n == 1) return nums[0];
        // if(nums[0] < nums[nums.length - 1]) return nums[0];

        // [4,5,6,7,0,1,2]
        // while(left < right)
        // left = 0
        // right = n - 1 = 6

        // step 1
        // mid = 0 + (6 - 0) / 2 = 3
        // if(nums[mid](7) > nums[right](2)) left = mid + 1 = 4

        // step 2
        // mid = 4 + (6 - 4) /2 = 5
        // if(nums[mid](1) <= nums[right](2)) right = mid = 5

        // step 3
        // mid = 4 + (5 - 4) /2 = 4
        // if(nums[mid](0) <= nums[right](1)) right = mid = 4
        // break while loop due to left == right
        // return nums[left](0);

        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] < nums[nums.length - 1]) return nums[0];

        int left = 0;
        int right = n - 1;

        while(left < right) {
            int mid = left + (right - left) /2;
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}
