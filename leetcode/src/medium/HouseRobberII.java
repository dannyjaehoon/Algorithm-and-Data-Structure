package medium;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robHouse(0, n-2, nums), robHouse(1, n-1,nums));
    }

    private int robHouse(int start, int end, int[] nums) {
        int[] dp = new int[nums.length];

        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);

        for(int i = start+2; i<=end; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[end];
    }
}
