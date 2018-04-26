/**
 * 
 * Date: 04/19/2018
 * Created By: Shuai Liu
 * 
 * You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into several subsequences, 
 * where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.
 * 
 * Example 1:
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3
 * 3, 4, 5
 * Example 2:
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * Example 3:
 * Input: [1,2,3,4,4,5]
 * Output: False
 * Note:
 * The length of the input is in range of [1, 10000]
 */
/**
 * The basic idea is that using greedy choice. If you can append current number into an existing consecutive array, it's better than you use this number as a
 * leading number of a new array. So the appendFreq map is to record current existing array finishing point. If there's a chain ending before x,
 * means x is already in the appendFreq map, then add it to that chian. Otherwise, if we can start a new chain, do so.
 */
import java.util.*;
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> appendFreq = new HashMap<>();
        for (int i : nums) freq.put(i, freq.getOrDefault(i, 0) + 1);
        for (int i : nums) {
            if (freq.get(i) == 0) continue;
            if (appendFreq.getOrDefault(i, 0) > 0) {
                appendFreq.put(i, appendFreq.get(i) - 1);
                appendFreq.put(i + 1, appendFreq.getOrDefault(i + 1, 0) + 1);
            }
            else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                appendFreq.put(i + 3, appendFreq.getOrDefault(i + 3, 0) + 1);
            }
            else return false;
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }
}