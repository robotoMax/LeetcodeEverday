/*
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * 
*/
import java.util.*;
public class Permutation {
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        helper(res, nums, new ArrayList<>(), visited);
        return res;
    }
    public void helper(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            temp.add(nums[i]);
            visited[i] = true;
            helper(res, nums, temp, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
        return;
    }
}