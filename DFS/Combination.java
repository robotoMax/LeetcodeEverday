/**
 * 
 * Date: 03/05/2018
 * Created By: Shuai Liu
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combination {
    public List<List<Integer>> solution(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, res, new ArrayList<>(), 1);
        return res;
    }
    public void helper(int n, int k, List<List<Integer>> res, List<Integer> temp, int pos) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos; i <= n; i++) {
            temp.add(i);
            helper(n, k, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
        return;
    }
}