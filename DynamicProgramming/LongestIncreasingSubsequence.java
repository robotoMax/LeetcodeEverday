/**
 * 
 * Date: 03/13/2018
 * Created By: Shuai Liu
 * 
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be 
 * more than one LIS combination, it is only necessary for you to return the length.
 * 
 * Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 */
// artical that illustrates how binary search works on this problem.
// https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/ 
public class LongestIncreasingSubsequence {
    // dp method O(n^2) time complexity
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) temp = Math.max(temp, dp[j]);
            }
            dp[i] = temp + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    // binary search O(nlong) time complexity
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] tail = new int[nums.length];
        int len = 1;
        tail[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < tail[0]) {
                tail[0] = nums[i];
            }
            else if (nums[i] > tail[len - 1]) {
                tail[len] = nums[i];
                len++;
            }
            else {
                int index = binarySearch(tail, 0, len - 1, nums[i]);
                tail[index] = nums[i];
            }
        }
        return len;
    }
    
    public int binarySearch(int[] nums, int start, int end, int key) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= key) {
                end = mid;
            }
            else start = mid + 1;
        }
        return end;
    }
}