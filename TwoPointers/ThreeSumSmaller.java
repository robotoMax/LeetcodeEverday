/**
 * 
 * Date: 04/02/2018
 * Created By: Shuai Liu
 * 
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n 
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * 
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * Return 2. Because there are two triplets which sums are less than 2:
 * [-2, 0, 1]
 * [-2, 0, 3]
 * Follow up:
 * Could you solve it in O(n2) runtime?
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int q = nums.length - 1;
            int p = i + 1;
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];
                if (sum < target) {
                    res += right - left;
                    left++;
                }
                else if (sum >= target) right--;
            }
        }
        return res;
    }
}