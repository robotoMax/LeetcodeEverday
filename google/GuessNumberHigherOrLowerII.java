/**
 * 
 * Date: 04/12/2018
 * Created By: Shuai Liu
 * 
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number 
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
 * the method is similar to number of distinct tree
 */
/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(dp, 1, n);
    }
    public int helper(int[][] dp, int i, int j) {
        if (i >= j) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        int res = Integer.MAX_VALUE;
        for (int x = i; x <= j; x++) {
            int temp = x + Math.max(helper(dp, i, x - 1), helper(dp, x + 1, j));
            res = Math.min(res, temp);
        }
        dp[i][j] = res;
        return res;
    }
}