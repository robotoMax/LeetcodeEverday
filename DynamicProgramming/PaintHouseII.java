/**
 * 
 * Date: 03/07/2018
 * Created By: Shuai Liu
 * 
 * There are a row of n houses, each house can be painted with one of the k colors. 
 * The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. 
 * For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting 
 * house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 * 
 * Note:
 * All costs are positive integers.
 * 
 * Follow up:
 * Could you solve it in O(nk) runtime?
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int preMin = 0;
        int preSecMin = 0;
        int preMinColor = -1;
        for (int i = 0; i < n; i++) {
            int curMin = Integer.MAX_VALUE;
            int curSecMin = Integer.MAX_VALUE;
            int curMinColor = -1;
            for (int j = 0; j < k; j++) {
                int val = costs[i][j] + (preMinColor == j ? preSecMin : preMin);
                if (curMinColor == -1) {
                    curMin = val;
                    curMinColor = j;
                }
                else if (val < curMin) {
                    curSecMin = curMin; 
                    curMin = val;
                    curMinColor = j;
                }
                else if (val < curSecMin) {
                    curSecMin = val;
                }
            }
            preMin = curMin;
            preMinColor = curMinColor;
            preSecMin = curSecMin;
        }
        return preMin;
    }
}