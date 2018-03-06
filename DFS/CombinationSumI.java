/**
 * 
 * Date: 03/05/2018
 * Created By: Shuai Liu
 * 
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 * [
 *   [7],
 *   [2, 2, 3]
 * ]
 */
import java.util.*;
public class CombinationSumI {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(candidates, target, res, new ArrayList<>(), 0, 0);
        return res;
    }
    public void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int cur, int pos) {
        if (cur == target) {
            res.add(new ArrayList<>(temp));
        }
        if (cur > target) return;
        if (pos == candidates.length) return;
        for (int i = pos; i < candidates.length; i++) {
            temp.add(candidates[i]);
            helper(candidates, target, res, temp, cur + candidates[i], i);
            temp.remove(temp.size() - 1);
        }
        return;
    }
}