/**
 * 
 * Date: 03/13/2018
 * Created By: Shuai Liu    
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
/**
 * use the way to solve Longest Palindromic Substring
 */
import java.util.*;
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]));
            }
        }
        helper(res, s, dp, 0, new ArrayList<>());
        return res;
    }
    public void helper(List<List<String>> res, String s, boolean[][] dp, int pos, List<String> temp) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (dp[pos][i]) {
                temp.add(s.substring(pos, i + 1));
                helper(res, s, dp, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}