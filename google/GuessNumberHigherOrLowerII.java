/**
 * Date: 04/12/2018
 * Created By: Shuai Liu
 * Type: Dynamic Programming, minmax.
 * 
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you 
 * guess the number 
 * 
 * I picked.
 * Example:
 * n = 10, I pick 8.
 * First round:  You
 *  guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * Game over. 8 is the number I picked.
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
/**
 * finding the maximum out of the minimum costs of its left and right segments
 * the method is similar to number of distinct tree.
 * 
 * For each number x in range[i~j]
 * we do: result_when_pick_x = x + max{DP([i~x-1]), DP([x+1, j])}
 * --> // the max means whenever you choose a number, the feedback is always bad and therefore leads you to a worse branch.
 * then we get DP([i~j]) = min{xi, ... ,xj}
 * --> // this min makes sure that you are minimizing your cost.
 * 
 */
public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(dp, 1, n);
    }
    public int helper(int[][] dp, int start, int end) {
        if (start >= end) return 0;
        if (dp[start][end] > 0) return dp[start][end];
        int res = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int temp = i + Math.max(helper(dp, start, i - 1), helper(dp, i + 1, end));
            res = Math.min(res, temp);
        }
        dp[start][end] = res;
        return dp[start][end];
    }
}