/**
 * 
 * Date: 03/09/2018
 * Created By: Shuai Liu
 * 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
/**
 * dp[i][j] means the number of operations from word1[0...i - 1] convert to word2[0...j - 1];
 * There are two cases:
 * 1. Boundary case: dp[i][0] and dp[0][j]. Means word1[0...i - 1] convert to "".
 * So dp[i][0] = i; dp[0][j] = j;
 * 2. General case:
 *  i. If word1[i - 1] == word2[j - 1], then no more operation is needed. dp[i][j] = dp[i - 1][j - 1].
 *  ii. They are not equal, then it has three situations to consider:
 *      a. Replace word1[i - 1] by word2[j - 1], dp[i][j] = dp[i - 1][j - 1] + 1;
 *      b. Delete word1[i - 1], word1[0...i - 2] = word2[0...j - 1], dp[i][j] = dp[i - 1][j] + 1; This means we convert word1[0... i - 2]
 *         to word2[0...j - 1], and costs extra 1 operation to delete.
 *      c. Insert word2[j - 1] to position i in word1. word1[0...i - 1] + word2[j - 1] = word2[0...j - 1]. 
 *         dp[i][j] = dp[i][j - 1] + 1;
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    public int solutionForEditDistancePlusTransposition(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int i = 0; i <= b.length(); i++) dp[0][i] = i;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int cost = 0;
                if (a.charAt(i) == b.charAt(j)) {
                    cost = 0;
                }
                else cost = 1;
            }
            dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1] + cost));
            if (i > 1 && j > 1 && a.charAt(i - 1) == b.charAt(j) && a.charAt(i) == b.charAt(j - 1))  {
                dp[i][j] = Math.min(dp[i][j], dp[i - 2][j - 2] + cost);
            }
        }
        return dp[a.length()][b.length()];
    }
}