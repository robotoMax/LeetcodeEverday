/**
 * Date: 06/17/2018
 * Created By: Shuai Liu
 * 
 * Given an array which consists of non-negative integers and an integer m, you can split the array into 
 * m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * 
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 
 * Examples:
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * Output:
 * 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int i : nums) {
            max = Math.max(max, i);
            sum += i;
        }
        if (m == 1) return (int) sum;
        long l = max;
        long r = sum;
        while (l <= r) {
            long mid = (r - l) / 2 + l;
            if (valid(mid, nums, m)) r = mid - 1;
            else l = mid + 1;
        }
        return (int) l;
    }
    public boolean valid(long mid, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int i : nums) {
            total += i;
            if (total > mid) {
                total = i;
                count++;
                if (count > m) return false;
            }
        }
        return true;
    }
}