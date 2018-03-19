/**
 * 
 * Date: 03/18/2018
 * Created By: Shuai Liu
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
import java.util.*;
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(nums, res, new ArrayList<>(), 0);
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int pos) {
        res.add(new ArrayList<>(temp));
        for (int i = pos; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}