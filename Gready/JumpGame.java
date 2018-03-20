/**
 * 
 * Date: 03/19/2018
 * Created By:Shuai Liu
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int dist = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > dist) return false;
            dist = Math.max(dist, i + nums[i]);
        }
        return true;
    }
}