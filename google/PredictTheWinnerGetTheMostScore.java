/**
 * Date: 04/19/2018
 * Created By: Shuai Liu
 * 
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then
 * player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been
 * chosen. The player with the maximum score wins.

 * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

 * Example 1:
 * Input: [1, 5, 2]
 * Output: False
 * Explanation: Initially, player 1 can choose between 1 and 2. 
 * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
 * So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
 * Hence, player 1 will never be the winner and you need to return False.
 * Example 2:
 * Input: [1, 5, 233, 7]
 * Output: True
 * Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
 * Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
 * Note:
 * 1. 1 <= length of the array <= 20.
 * 2. Any scores in the given array are non-negative integers and will not exceed 10,000,000.
 * 3. If the scores of both players are equal, then player 1 is still the winner.
 */
/**
 * in this problem, you need to return the maximum points that player 1 can get.
 */
public class PredictTheWinnerGetTheMostScore {
    int[][] dp;
    public int solution(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        dp = new int[nums.length][nums.length];
        helper(nums, 0, nums.length - 1, true);
        return dp[0][nums.length - 1];
    }
    public int helper(int[] nums, int start, int end, boolean myTurn) {
        if (start == end) return nums[start];
        if (dp[start][end] > 0) return dp[start][end];
        int res = 0;
        if (myTurn) {
            res = Math.max(helper(nums, start + 1, end, false) + nums[start], helper(nums, start, end - 1, false) + nums[end]);
        }
        else {
            // if this is the second player's ture, my min is his max. And the second player is not stupid, so he must choose the max numbuer he can choos. 
            res = Math.min(helper(nums, start + 1, end, true), helper(nums, start, end - 1, true));
        }
        dp[start][end] = res;
        return res;
    }
    public static void main(String[] args) {
        PredictTheWinnerGetTheMostScore p = new PredictTheWinnerGetTheMostScore();
        int[] nums = {1,5,233,7};
        System.out.println(p.solution(nums));
    }
}