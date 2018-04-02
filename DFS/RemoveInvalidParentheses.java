/**
 * 
 * Date: 03/31/2018
 * Created By: Shuai Liu
 * 
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
import java.util.*;
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, 0, new char[] {'(', ')'});
        return res;
    }
    public void helper(List<String> res, String s, int lasti, int lastj, char[] p) {
        int count = 0;
        for (int i = lasti; i < s.length(); i++) {
            if (s.charAt(i) == p[0]) count++;
            if (s.charAt(i) == p[1]) count--;
            if (count >= 0) continue;
            for (int j = lastj; j <= i; j++) {
                if (s.charAt(j) == p[1] && (j == lastj || s.charAt(j - 1) != p[1])) {
                    helper(res, s.substring(0, j) + s.substring(j + 1), i, j, p);
                }
            }
            return;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if (p[0] == '(') {
            helper(res, reverse, 0, 0, new char[] {')', '('});
        }
        else res.add(reverse);
    }
}