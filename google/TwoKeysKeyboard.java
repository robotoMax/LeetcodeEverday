/**
 * 
 * Date: 04/07/2018
 * Created By: Shuai Liu
 * 
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
 * 
 * Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * 
 * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. 
 * Output the minimum number of steps to get n 'A'.
 * 
 * Example 1:
 * Input: 3
 * Output: 3
 * Explanation:
 * Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * Note:
 * The n will be in the range [1, 1000].
 */
public class TwoKeysKeyboard {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    // i = 9; j = 3; AAA can be seems as a whole, so to get AAA AAA AAA, it just takes from A to AAA times + AAA to AAA AAA AAA
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        return dp[n];
    }
}