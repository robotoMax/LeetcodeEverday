/**
 * 
 * Date: 03/19/2018
 * Created By: Shuai Liu
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps 
 * to the last index.)
 * 
 * Note:
 * You can assume that you can always reach the last index.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int i = 0;
        int level = 0;
        int curMax = 0;
        int dist = 0;
        while (i <= curMax) {
            level++;
            while (i <= curMax) {
                dist = Math.max(dist, nums[i] + i);
                if (dist >= nums.length - 1) return level;
                i++;
            }
            curMax = dist;
        }
        return 0;
    }
    // gready
    public int jump1(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int curMax = 0;
        int dist = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            dist = Math.max(dist, nums[i] + i);
            if (curMax == i) {
                res++;
                curMax = dist;
            }
        }
        return res;
    }
}