package easy;

public class BinarySearch {

    public int search(int[] nums, int target) {

        // [-1,0,3,5,9,12]
        // left = 0
        // right = nums.length -1 = 5;

        // When calculating the midpoint using (left + right) / 2, there's a potential risk of integer overflow if left and right are both large values.

        // while loop - left <= right
        // find the mid (left + ( right - left) /2)
        // if(nums[mid] == target) return mid;
        // if(nums[mid] > target) mid = right -1
        // if(nums[mid] < target) mid = left+1


        int n = nums.length;
        int left = 0;
        int right = n-1;

        while(left <= right) {
            int mid = left + (right - left) /2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                right = mid -1;
            } else {
                left = mid +1;
            }
        }
        return -1;

    }
}
