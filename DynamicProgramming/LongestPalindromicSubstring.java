/**
 * 
 * Date: 03/13/2018
 * Created By: Shuai Liu
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum 
 * length of s is 1000.
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]));
                if (dp[j][i] && i - j + 1 > res.length()) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }
}