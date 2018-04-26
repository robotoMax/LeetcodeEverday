/**
 * 
 * Date: 04/11/2018
 * Created By: Shuai Liu
 * 
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of 
 * painting each house with a certain color is different. You have to paint all the houses such that no two adjacent 
 * houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is 
 * the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... 
 * Find the minimum cost to paint all houses.
 * 
 * Note:
 * All costs are positive integers.
 */
// output shoule be which house need to be painted what color.
import java.util.*;
public class PaintHouseWithEveryChoice {
    public List<String> solution(int[][] costs) {
        List<String> res = new ArrayList<>();
        if (costs == null || costs.length == 0) return res;
        int[][] dp = new int[costs.length][costs[0].length];
        for (int i = 0; i < costs[0].length; i++) dp[0][i] = costs[0][i];
        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
        }
        for (int i = 0; i < costs.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        int pre = -1;
        int min = Math.min(dp[costs.length - 1][0], Math.min(dp[costs.length - 1][1], dp[costs.length - 1][2]));        
        for (int i = costs.length - 1; i >= 0; i--) {
            System.out.println(min);
            if (dp[i][0] == min && pre != 0) {
                res.add(0, "red");
                pre = 0;
                min -= costs[i][0];
            }
            if (dp[i][1] == min && pre != 1) {
                res.add(0, "blue");
                pre = 1;
                min -= costs[i][1];                
            }
            if (dp[i][2] == min && pre != 2) {
                res.add(0, "green");
                pre = 2;
                min -= costs[i][2];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        PaintHouseWithEveryChoice p = new PaintHouseWithEveryChoice();
        int[][] costs = {{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
        List<String> res = p.solution(costs);
        System.out.println(res.toString());
    }
}