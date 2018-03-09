/**
 * 
 * Date: 03/08/2018
 * Created By: Shuai Liu
 * 
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack
 */
/**
 * dp[i][j] i represents the ith item, j represents weight j
 */
public class KnapSack {
    public int solution(int[] value, int[] weights, int weight) {
        int[][] dp = new int[value.length + 1][weight + 1];
        for (int i = 0; i <= value.length; i++) {
            for (int j = 0; j <= weight; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], (j >= weights[i - 1] ? dp[i - 1][j - weights[i - 1]] : 0 + value[i - 1])); // dp[i - 1] means exclude the current ith item.
            }
        }
        return dp[value.length][weight];
    }
}