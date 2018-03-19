/**
 * 
 * Date: 03/18/2018
 * Created By: Shuai Liu
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
/**
 * Explanation:
 * Let’s say nums looks like this: [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 * Because it’s not fully sorted, we can’t do normal binary search. But here comes the trick:
 * If target is let’s say 14, then we adjust nums to this, where “inf” means infinity:
 * [12, 13, 14, 15, 16, 17, 18, 19, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]
 * 
 * If target is let’s say 7, then we adjust nums to this:
 * [-inf, -inf, -inf, -inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 * And then we can simply do ordinary binary search.
 * 
 * Of course we don’t actually adjust the whole array but instead adjust only on the fly only the elements we look at. 
 * And the adjustment is done by comparing both the target and the actual element against nums[0].
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        int num = 0;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (target < nums[0] == nums[mid] < nums[0]) {  // target and nums[mid] are in the same side;
                num = nums[mid];
            } 
            else { // target and nums[mid] are not in the same side
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                // num = target >= nums[0] ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            if (num > target) high = mid - 1;
            else if (num < target) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}