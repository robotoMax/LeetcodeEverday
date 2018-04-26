/**
 * 
 * Date: 04/11/2018
 * Created By: Shuai Liu
 * 
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        int max = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        for (int i : nums) {
            if (i == min || i == max) continue;
            int index = (i - min) / gap;
            bucketMin[index] = Math.min(bucketMin[index], i);
            bucketMax[index] = Math.max(bucketMax[index], i);
        }
        int res = 0;
        int pre = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketMax[i] == Integer.MIN_VALUE && bucketMin[i] == Integer.MAX_VALUE) continue;
            res = Math.max(res, bucketMin[i] - pre);
            pre = bucketMax[i];
        }
        res = Math.max(res, max - pre);
        return res;
    }
}