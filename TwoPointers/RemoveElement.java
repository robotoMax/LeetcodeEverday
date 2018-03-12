/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative 
 * order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of operations.
 */
/**
 * similar with move zeroes
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) right++;
            else {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right++;
            }
        }
        return left;
    }
}