/**
 * 
 * Date: 03/07/2018
 * Created By: Shuai Liu
 * 
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
/**
 * there are 4 ways to solve this problem;
 * 1. Brute force: check even length of the substring to see whether they are valid
 * 2. DP: check two conditions. ')' and '))'
 * 3. Stack: push '(' index to the stack, if ')' pop and get the length. if stack is empty, push current index
 * 4. 2 variables: left and right. 2 passes. first from left to the right, when encounter '(' left++, else right++, if left == right, get
 * the length. Then scaning the string from right to left. doing the above steps. Compare these two results.
 */
import java.util.*;
public class LongestValidParentheses {
    // DP:
    public int longestValidParenthesesDP(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                else if (s.charAt(i - 1) == ')') {
                    if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
    // stack:
    public int longestValidParenthesesStack(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}