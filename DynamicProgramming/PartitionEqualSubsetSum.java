/**
 * Date: 05/29/2018
 * Created By: Shuai Liu
 * 
 * Type: Dynamic Programming
 * 
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that 
 * the sum of elements in both subsets is equal.
 * 
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */

// bottom up
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[target];
    }
    // top-down. But it will TLE if the test case = [1,1,1,1,1,1,1........];
    public boolean canPartition1(int[] nums) {    
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        return helper(dp, target, nums.length, nums);
    }
    public boolean helper(boolean[] dp, int tar, int remain, int[] nums) {
        if (tar < 0) return false;
        if (tar == 0) return true;
        if (dp[tar]) return true;
        for (int i = remain; i > 0; i--) {        
            dp[tar] = dp[tar] || helper(dp, tar - nums[i - 1], i - 1, nums);
        }
        return dp[tar];
    }
}