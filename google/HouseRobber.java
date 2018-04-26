/**
 * 
 * Date: 04/20/2018
 * Created By: Shuai Liu
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money 
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system 
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount 
 * of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // int[] dp = new int[nums.length + 1];
        // dp[0] = 0;
        // dp[1] = nums[0];
        // int res = nums[0];
        // for (int i = 2; i <= nums.length; i++) {
        //     dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        //     res = Math.max(res, dp[i]);
        // }
        // return res;
        //**************************************************************
        // int include = nums[0];
        // int exclude = 0;
        // for (int i = 1; i < nums.length; i++) {
        //     int temp = include;
        //     include = nums[i] + exclude;
        //     exclude = Math.max(exclude, temp);
        // }
        // return Math.max(exclude, include);
        //**************************************************************
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = nums[nums.length - 1];
        return helper(nums, dp, nums.length);
    }
    public int helper(int[] nums, int[] dp, int left) {
        if (dp[left] != -1) return dp[left];
        int res = Math.max(helper(nums, dp, left - 2) + nums[nums.length - left], helper(nums, dp, left - 1));
        dp[left] = res;
        return res;
    }
}