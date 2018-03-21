/**
 * 
 * Date: 03/20/2018
 * Created By: Shuai Liu
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers 
 * on the row below.
 * 
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in 
 * the triangle.
 */
import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowNum = triangle.size();
        int[] dp = new int[rowNum];
        for (int i = 0; i < rowNum; i++) {
            dp[i] = triangle.get(rowNum - 1).get(i);
        }
        for (int i = rowNum - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}