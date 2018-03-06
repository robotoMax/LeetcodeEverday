/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * 
 */
import java.util.*;
public class GenerateParentheses {
    public List<String> solution(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        StringBuilder sb = new StringBuilder();
        helper(n, res, 0, 0, sb);
        return res;
    }
    public void helper(int n, List<String> res, int left, int right, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (left > right) {
            sb.append(")");
            helper(n, res, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left < n) {
            sb.append("(");
            helper(n, res, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);            
        }
        return;
    }
}