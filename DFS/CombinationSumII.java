/**
 *
 * Date: 03/05/2018
 * Created By: Shuai Liu
 *
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 * A solution set is: 
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 
 * time complexity is O(2^n)
 * 
 */
import java.util.*;
public class CombinationSumII {
    public List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(candidates, target, res, new ArrayList<>(), 0, 0);
        return res;
    }
    public void helper(int[] nums, int target, List<List<Integer>> res, List<Integer> temp, int cur, int pos) {
        if (cur == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (cur + nums[i] > target) continue;
            if (i > pos && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            helper(nums, target, res, temp, cur + nums[i], i + 1);
            temp.remove(temp.size() - 1);
        }
        return;
    }
    public static void main(String[] args) {
        CombinationSumII c = new CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = c.solution(candidates, target);
        for (List<Integer> temp : res) 
            System.out.println(temp.toString());
    }
}
