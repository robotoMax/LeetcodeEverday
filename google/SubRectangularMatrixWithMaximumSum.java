/**
 * Write a program to find maximum sum rectangle in give 2D matrix.
 * Assume there is at least one positive number in the 2D matrix.
 * 
 * Solution:
 * Keep temp array with size as number of rows. Start left and right from 0
 * and keep adding values for each row and maintain them in this temp array.
 * Run Kadane's algorithm to find max sum subarray in temp. Now increment right by
 * 1. When right reaches last column reset right to 1 and left to 1.
 * 
 * Space complexity of this algorithm is O(row)
 * Time complexity of this algorithm is O(row*col*col)
 * 
 */
public class SubRectangularMatrixWithMaximumSum {
    public int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 0;
        for (int left = 0; left < matrix[0].length; left++) {
            int[] dp = new int[matrix.length];
            for (int right = left; right < matrix[0].length; right++) {
                for (int i = 0; i < matrix.length; i++) {
                    dp[i] += matrix[i][right];
                }
                int curMax = kadane(dp);
                res = Math.max(res, curMax);
            }
        }
        return res;
    }
    public int kadane(int[] dp) {
        int res = dp[0];
        int sum = dp[0];
        for (int i = 1; i < dp.length; i++) {
            sum = Math.max(dp[i], sum + dp[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
    public static void main(String[] args) {
        SubRectangularMatrixWithMaximumSum s = new SubRectangularMatrixWithMaximumSum();
        int[][] matrix = {{ 2,  1, -3, -4,  5},
                         { 0,  6,  3,  4,  1},
                         { 2, -2, -1,  4, -5},
                         {-3,  3,  1,  0,  3}};
        int[][] matrix1 = {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        System.out.println(s.solution(matrix1));
    }
}