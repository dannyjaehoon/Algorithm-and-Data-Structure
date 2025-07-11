package easy;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // [1,3,5,6]
        // target = 5
        // left = 0;
        // right = n -1 = 3

        // while(left <= right)
        // step 1
        // mid = 0 + (3 - 0) /2 = 1
        // if(nums[mid](3) < target(5)) left = mid + 1 = 2;

        // step 2
        // mid = 2 + (3 - 2) / 2 = 2
        // if(nums[mid](5) >= target(5)) right = mid = 2;
        // return left(2)

        // target = 2
        // step 1
        // mid = 1
        // if(nums[mid](3) >= target(2)) right = mid;

        // step 2
        // mid = 0 + (1 - 0) /2  = 0
        // if(nums[mid](1) < target(2)) left = mid + 1 = 1;
        // while(left(1) < right(1)) break;
        // return left(1)

        // target = 7
        // if(target <=nums[0]) return 0;
        // if(target > nums[nums.lenth - 1]) return nums.length;
        // if(target == nums[nums.lenth - 1]) return nums.length - 1;

        int n = nums.length;
        if(target <= nums[0]) return 0;
        if(target > nums[n - 1]) return n;
        if(target == nums[n - 1]) return n-1;


        int left = 0;
        int right = n - 1;

        while(left < right) {
            int mid = left + (right - left) /2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
