/**
 * 
 * Date: 04/04/2018
 * Created By: Shuai Liu
 * 
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that 
 * add up to a positive integer target.
 * Example:
 * nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Therefore the output is 7.
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
public class CombinationSum4 {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }
    public int helper(int[] nums, int target) {
        if (dp[target] != -1) return dp[target];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }
    public static void main(String[] args) {
        CombinationSum4 c = new CombinationSum4();
        int[] nums = {1,2,3};
        int target = 32;
        System.out.println(c.solution(nums, target));
    }
}