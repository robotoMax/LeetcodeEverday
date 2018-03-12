/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
/**
 * 
 * dp[i][j] means if s[0...i - 1] matches p[0...j - 1]
 * 
 * 1. if s.charAt(i) == p.charAt(j): dp[i][j] = dp[i - 1][j - 1];
 * 2. if p.charAt(j) == '.': dp[i][j] = dp[i - 1][j - 1];
 * 3. if p.charAt(j) == '*': 
 *      a. if p.charAt(j - 1) != s.charAt(i): dp[i][j] = dp[i][j - 2]; consider a* as empty
 *      b. if p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.':
 *          i. dp[i][j] = dp[i][j - 2]. consider a* as empty;
 *          ii. dp[i][j] = dp[i][j - 1]. consider a* as single a
 *          iii. dp[i][j] = dp[i - 1][j]. consider a* multiple times
 * 4. initialization: 
 * dp[0][0] = true; 
 * if s: "aab" p: "c*aab" 
 * p.charAt(1) == '*' && dp[0][0] = true ---> dp[0][2] = true; it means that we delete "c*" in string p.
 *  
 * hidden assumption: the first character cannot be '*'
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    }
                    else {
                        dp[i][j] = (dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}