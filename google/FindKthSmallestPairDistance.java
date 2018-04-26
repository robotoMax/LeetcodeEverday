/**
 * 
 * Date: 04/15/2018
 * Created By: Shuai Liu
 * 
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) 
 * is defined as the absolute difference between A and B.
 * Example 1:
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0 
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * Note:
 * 1. 2 <= len(nums) <= 10000.
 * 2. 0 <= nums[i] < 1000000.
 * 3. 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
import java.util.*;
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int low = nums[1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            low = Math.min(low, nums[i] - nums[i - 1]);
        }
        int high = nums[nums.length - 1] - nums[0];
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (getPos(nums, mid) < k) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public int getPos(int[] nums, int mid) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += binarySearch(nums, mid + nums[i]) - (i + 1);
        }
        return res;
    }
    public int binarySearch(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] <= target) i = mid + 1;
            else j = mid;
        }
        return i;
    }
}