/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * Given a sorted array consisting of only integers where every element appears twice except for 
 * one element which appears once. Find this single element that appears only once.
 * 
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (mid % 2 == 1) mid--;
            // ensure that left, right, mid are in the even position of the array. just looking for the odd position
            if (nums[mid] == nums[mid + 1]) left = mid + 2; 
            else right = mid;
        }
        return nums[left];
    }
}