/**
 * Date: 06/12/2018
 * Created By: Shuai Liu
 * 
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * 
 * Example:
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3 
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 */
import java.util.*;
public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Long> map = new TreeMap<>();
        map.put(0l, 1l);
        long curSum = 0;
        int res = 0;
        for (int i : nums) {
            curSum += i;
            long from = curSum - upper;
            long to = curSum - lower;
            Map<Long, Long> submap = map.subMap(from, true, to, true);
            for (long key : submap.keySet()) res += submap.get(key);
            map.put(curSum, map.getOrDefault(curSum, 0l) + 1);
        }
        return res;
    }
    // using merge sort can decrease the time complexity
    /**
     * 对于mergesort，在merge阶段，我们已经有了两个已经排好序的子数组，并且对于subarray A和subarray B中的元素的相对位置是没问题的。所以，我们考虑cross pair[i, j],
     * index i在A数组中，index j在B数组中。
     */
    long[] prefixSum;
    long[] temp;
    int res;
    public int countRangeSum1(int[] nums, int lower, int upper) {
        prefixSum = new long[nums.length + 1];
        temp = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        mergeSort(0, prefixSum.length - 1, lower, upper);
        return res;
    }
    public void mergeSort(int start, int end, int lower, int upper) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid, lower, upper);
        mergeSort(mid + 1, end, lower, upper);
        merge(start, mid, end, lower, upper);
    }
    public void merge(int start, int mid, int end, int lower, int upper) {
        int tempIndex = start;
        int right = mid + 1;
        int low = mid + 1;
        int high = mid + 1;
        for (int left = start; left <= mid; left++) {
            while (low <= end && prefixSum[low] - prefixSum[left] < lower) low++;
            while (high <= end && prefixSum[high] - prefixSum[left] <= upper) high++;
            while (right <= end && prefixSum[left] > prefixSum[right]) temp[tempIndex++] = prefixSum[right++];
            temp[tempIndex++] = prefixSum[left];
            res += high - low;
        }
        while (right <= end) temp[tempIndex++] = prefixSum[right++];
        for (int i = start; i <= end; i++) prefixSum[i] = temp[i];
    }
}