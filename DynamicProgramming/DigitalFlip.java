/**
 * 
 * Date: 03/10/2018
 * Created By: Shuai Liu
 * 
 * 给你一个01构成的数组。请你找出最小翻转步数，使得数组满足以下规则：
 * 1的后面可以是1或者0，但是0的后面必须是0。
 * Example
 * Given array = [1,0,0,1,1,1], return 2.
 * 
 * Explanation:
 * Turn two 0s into 1s.
 * Given array = [1,0,1,0,1,0], return 2.
 * 
 * Explanation:
 * Turn the second 1 and the third 1 into 0.
 */
public class DigitalFlip {
    public int flipDigit(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        // if the last number is 0, then dp[i][1] should be 1; if the last number is 1, then dp[i][0] should be 1;
        dp[nums.length - 1][1 - nums[nums.length - 1]] = 1; 
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 1) {
                dp[i][1] = Math.min(dp[i + 1][1], dp[i + 1][0]);
                dp[i][0] = dp[i + 1][0] + 1;
            }
            else {
                dp[i][1] = Math.min(dp[i + 1][1], dp[i + 1][0]) + 1;
                dp[i][0] = dp[i + 1][0];
            }
        }
        return Math.min(dp[0][0], dp[0][1]);
    }
}