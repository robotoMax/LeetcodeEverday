/**
 * 
 * Date: 04/16/2018
 * Created By: Shuai Liu
 * 
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum 
 * is no larger than k.
 * 
 * Example:
 * Given matrix = [
 *   [1,  0, 1],
 *   [0, -2, 3]
 * ]
 * k = 2
 * The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).
 * Note:
 * 1. The rectangle inside the matrix must have an area > 0.
 * 2. What if the number of rows is much larger than the number of columns?
 */
/**
 * The very important thing is that when we come to the subarray sum is k, how to get it?
 * We can use map or set and keep a prefix sum. If the map or set contains prefixSum - k. Then we find the one.
 */
import java.util.*;
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        for (int left = 0; left < matrix[0].length; left++) {
            int[] dp = new int[matrix.length];
            for (int right = left; right < matrix[0].length; right++) {
                for (int i = 0; i < matrix.length; i++) {
                    dp[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int curSum = 0;
                for (int i : dp) {
                    curSum += i;
                    Integer num = set.ceiling(curSum - k);
                    if (num != null) res = Math.max(res, curSum - num);
                    set.add(curSum);
                }
            }
        }
        return res;
    }
}