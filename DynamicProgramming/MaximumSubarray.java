/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    // using dp array
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    // using constant space
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
    // divide and conquer
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }
    public int helper(int[] nums, int x, int y) {
        if (x == y) return nums[x];
        int mid = (y - x) / 2 + x;
        int left = helper(nums, x, mid);
        int right = helper(nums, mid + 1, y);
        int temp = 0;
        int leftMax = nums[mid];
        int rightMax = nums[mid + 1];
        for (int i = mid; i >= x; i--) {
            temp += nums[i];
            leftMax = Math.max(temp, leftMax);
        }
        temp = 0;
        for (int i = mid + 1; i <= y; i++) {
            temp += nums[i];
            rightMax = Math.max(temp, rightMax);
        }
        return Math.max(Math.max(left, right), leftMax + rightMax);
    }
}