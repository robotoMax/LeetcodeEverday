/**
 * 
 * Date: 03/18/2018
 * Created By: Shuai Liu
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Write a function to determine if a given target is in the array.
 * The array may contain duplicates.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target) return true;
            // if the left side is sorted or the right side are not sorted
            // 4 5 6 7 8 0 1 2 find 6, mid = 7, so left side is sorted
            // 4 5 6 7 8 0 1 2 find 1, mid = 7, so right side is unsorted
            else if (nums[low] < nums[mid] || nums[high] < nums[mid]) { 
                if (nums[low] <= target && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            }
            // if the left side is unsorted or the right side is sorted
            else if (nums[mid] < nums[low] || nums[mid] < nums[high]) {
                if (nums[mid] < target && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
            else low++;
        }
        return false;
    }   
}