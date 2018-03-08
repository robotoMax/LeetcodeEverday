/**
 * 
 * Date: 03/07/2018
 * Created By: Shuai Liu
 * 
 * Given an array of n integers where n > 1, nums, return an array output such that
 *  output[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not 
 * count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
       if (nums == null || nums.length == 0) return nums;
       int[] res = new int[nums.length];
       res[0] = 1;
       for (int i = 1; i < nums.length; i++) {
           res[i] = nums[i - 1] * res[i - 1];
       }
       int p = 1;
       for (int i = nums.length - 1; i >= 0; i--) {
           res[i] = res[i] * p;
           p *= nums[i];
       }
       return res;
    }
}