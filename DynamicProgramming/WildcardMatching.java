/**
 * 
 * Date: 03/19/2018
 * Created By: Shuai Liu
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else dp[i][j] = false;
            }
        }
        return dp[m][n];
    }
    // For dp[i - 1][j] indicates that if s.substring(0, i - 1) matches p.substring(0, j). Then * can represents 
    // character s.charAt(i);
    // For dp[i][j - 1] indicates that * is empty.
}