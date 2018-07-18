/**
 * Date: 07/10/2018
 * Created By: Shuai Liu
 * 
 * Given several boxes with different colors represented by different positive numbers. 
 * You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the 
 * same color (composed of k boxes, k >= 1), remove them and get k*k points.
 * 
 * Find the maximum points you can get.
 * Example 1:
 * Input:
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * Output:
 * 23
 * Explanation:
 * [1, 3, 2, 2, 2, 3, 4, 3, 1] 
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 points) 
 * ----> [1, 3, 3, 3, 1] (1*1=1 points) 
 * ----> [1, 1] (3*3=9 points) 
 * ----> [] (2*2=4 points)
 * Note: The number of boxes n would not exceed 100.
 */
public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) return 0;
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return helper(boxes, dp, 0, n - 1, 0);
    }
    public int helper(int[] boxes, int[][][] dp, int start, int end, int len) {
        if (start > end) return 0;
        if (dp[start][end][len] > 0) return dp[start][end][len];
        for (; start <= end - 1 && boxes[start] == boxes[start + 1]; start++, len++);
        int res = (len + 1) * (len + 1) + helper(boxes, dp, start + 1, end, 0);
        for (int i = start + 1; i <= end; i++) {
            if (boxes[i] == boxes[start]) res = Math.max(res, helper(boxes, dp, start + 1, i - 1, 0) + helper(boxes, dp, i, end, len + 1));
        }
        dp[start][end][len] = res;
        return res;
    }
}