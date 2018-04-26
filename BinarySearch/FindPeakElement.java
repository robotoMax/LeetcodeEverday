/**
 * 
 * Date: 04/11/2018
 * Created By: Shuai Liu
 * 
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}