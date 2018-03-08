/**
 * 
 * Date: 03/07/2018
 * Created By: Shuai Liu
 * 
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 * Note:
 * n and k are non-negative integers.
 */
/**
 * 1 2 3
 * if 3 is different from 2, then it should be (k - 1) * total
 * if 3 is same as 2, then it should be same as the different number with 1 and 2
 * 
 * diff: (k - 1) * total
 * same: last diff
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int same = 0;
        int total = k;
        int diff = k;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = (k - 1) * total;
            total = same + diff;
        }
        return total;
    }
}