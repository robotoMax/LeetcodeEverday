/**
 * 
 * Date: 03/08/2018
 * Created By: Shuai Liu
 * 
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
/**
 * similar with problem Longest Increasing Path in a Matrix
 */
import java.util.Arrays;
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        Integer[] dp = new Integer[amount + 1];
        dp[0] = 0;
        return helper(coins, amount, dp);
    }
    public int helper(int[] coins, int remain, Integer[] dp) {
        if (dp[remain] != null) return dp[remain];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (remain >= coins[i]) {
                int temp = helper(coins, remain - coins[i], dp);
                if (temp != -1) {
                    res = Math.min(res, temp + 1);
                }
            }
        }
        dp[remain] = res == Integer.MAX_VALUE ? -1 : res;
        return dp[remain];
    }
}