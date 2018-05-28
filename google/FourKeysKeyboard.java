/**
 * 
 * Date: 04/07/2018
 * Created By: Shuai Liu
 * 
 * Imagine you have a special keyboard with the following keys:
 * Key 1: (A): Print one 'A' on screen.
 * Key 2: (Ctrl-A): Select the whole screen.
 * Key 3: (Ctrl-C): Copy selection to buffer.
 * Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
 * Now, you can only press the keyboard for N times (with the above four keys), find out the maximum numbers of 
 * 'A' you can print on screen.
 * 
 * Example 1:
 * Input: N = 3
 * Output: 3
 * Explanation: 
 * We can at most get 3 A's on screen by pressing following key sequence:
 * A, A, A
 * Example 2:
 * Input: N = 7
 * Output: 9
 * Explanation: 
 * We can at most get 9 A's on screen by pressing following key sequence:
 * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 * Note:
 * 1. 1 <= N <= 50
 * 2. Answers will be in the range of 32-bit signed integer.
 */
/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
public class FourKeysKeyboard {
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = i;
            /**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
            for (int j = 1; j <= i - 3; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        return dp[N];
    }
}