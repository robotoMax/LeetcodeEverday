/**
 * Date: 06/04/2018
 * Created By: Shuai Liu
 * 
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of 
 * elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * Example 1:
 * nums: [1,2,3]
 * Result: [1,2] (of course, [1,3] will also be ok)
 * 
 * Example 2:
 * nums: [1,2,4,8]
 * Result: [1,2,4,8]
 */
import java.util.*;
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] counts = new int[nums.length];
        int[] pre = new int[nums.length];
        int index = -1;
        int max = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            counts[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (counts[i] < counts[j] + 1) {
                        counts[i] = counts[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (max < counts[i]) {
                max = counts[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}