/**
 * 
 * Date: 03/22/2018
 * Created By: Shuai Liu
 * 
 * given two strings, return the longest common substring
 */
public class LongestCommonSubstring {
    public int solution(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        int res = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {/**
                * Created By: Shuai Liu
                * 请勿作为商业用处。尊重劳动成果
                */
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
                else  dp[i][j] = 0;
            }/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
        }
        return res;
    }
    public static void main(String[] args) {
        LongestCommonSubstring l = new LongestCommonSubstring();
        String a = "abcdefg";
        String b = "zgcdegddefg";
        System.out.println(l.solution(a, b));
    }
}