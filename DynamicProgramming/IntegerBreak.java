/**
 * 
 * Date: 03/28/2018
 * Created By: Shuai Liu
 * 
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. 
 * Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {
    // memoization
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
    // deduction -- come up with the solution by myself
    public int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        return helper(dp, n);
    }
    public int helper(int[] dp, int target) {
        if (dp[target] > 0) return dp[target];
        for (int i = 1; i <= target; i++) {
            dp[target] = Math.max(dp[target], Math.max(target - i, helper(dp, target - i)) * Math.max(i, dp[i]));
        }
        return dp[target];
    }
}