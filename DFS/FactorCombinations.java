/**
 * 
 * Date: 04/02/2018
 * Created By: Shuai Liu
 * 
 * Numbers can be regarded as product of its factors. For example,
 * 
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * 
 * Note: 
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Examples: 
 * input: 1
 * output: 
 * []
 * input: 37
 * output: 
 * []
 * input: 12
 * output:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 * input: 32
 * output:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 */
import java.util.*;
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 1) return res;
        helper(res, n, new ArrayList<>(), 2);
        return res;
    }
    public void helper(List<List<Integer>> res, int n, List<Integer> temp,  int cur) {
        if (n == 1) {
            if (temp.size() > 1) {
                res.add(new ArrayList<>(temp));
                return;
            }
        }
        for (int i = cur; i <= n; i++) {
            if (n % i != 0) continue;
            temp.add(i);
            helper(res, n / i, temp, i);
            temp.remove(temp.size() - 1);
        }
    }
}