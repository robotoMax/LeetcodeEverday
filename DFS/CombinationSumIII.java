/**
 * 
 * Date: 03/05/2018
 * Created By: Shuai Liu
 * 
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 */
import java.util.*;
public class CombinationSumIII {
    public List<List<Integer>> solution(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) return res;
        helper(k, n, res, new ArrayList<>(), 0, 1);
        return res;
    }
    public void helper(int k, int n, List<List<Integer>> res, List<Integer> temp, int sum, int pos) {
        if (sum == n && temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos; i <= 9; i++) {
            if (sum + i > n) continue;
            temp.add(i);
            helper(k, n, res, temp, sum + i, i + 1);
            temp.remove(temp.size() - 1);
        }
        return;
    }
    public static void main(String[] args) {
        CombinationSumIII c = new CombinationSumIII();
        int k = 3;
        int n = 7;
        List<List<Integer>> res = c.solution(k, n);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }
}