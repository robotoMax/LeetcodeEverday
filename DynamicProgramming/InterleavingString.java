/**
 * 
 * Date: 03/16/2018
 * Created By: Shuai Liu
 * 
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1]);
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = (s2.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]);
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int index = i + j - 1;
                dp[i][j] = (s1.charAt(j - 1) == s3.charAt(index) && dp[i][j - 1])
                            || (s2.charAt(i - 1) == s3.charAt(index) && dp[i - 1][j]);
            }
        }
        return dp[s2.length()][s1.length()];
    }
}