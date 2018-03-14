/**
 * 
 * Date: 03/13/2018
 * Created By: Shuai Liu
 * 
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given 
 * array, and the length of an increasing subsequence should be at least 2 .
 * 
 * Example:
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * Note:
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special 
 * case of increasing sequence.
 */
import java.util.*;
public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        helper(nums, set, 0, new ArrayList<>());
        List res = new ArrayList(set);
        return res;
    }
    public void helper(int[] nums, Set<List<Integer>> set, int pos, List<Integer> temp) {
        if (temp.size() >= 2) {
            set.add(new ArrayList<>(temp));
        }
        for (int i = pos; i < nums.length; i++) {
            if (temp.isEmpty() || (temp.get(temp.size() - 1) <= nums[i])) {
                temp.add(nums[i]);
                helper(nums, set, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
        return;
    }
}