/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
import java.util.*;
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums, res, new ArrayList<>(), visited, 0);
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] visited, int pos) {
        res.add(new ArrayList<>(temp));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1] || visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            helper(nums, res, temp, visited, i + 1);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}