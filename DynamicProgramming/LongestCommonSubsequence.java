/**
 * Date: 04/04/2018
 * Created By: Shuai Liu
 * 
 * Given two strings, return the longest common subsequence.
 * a = "acded" b = "agggdgggd";
 * return 3. which is "add";
 */
public class LongestCommonSubsequence {
    public int solution(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (a.charAt(i - 1) == b.charAt(j - 1)) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[a.length()][b.length()];
    }
    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String a = "acded";
        String b = "agggdgggd";
        System.out.println(longestCommonSubsequence.solution(a, b));
    }
}