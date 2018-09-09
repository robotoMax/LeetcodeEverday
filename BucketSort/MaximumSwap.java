/**
 * Date: 08/27/2018
 * Created By: Shuai Liu
 * 
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued 
 * number you could get.
 * 
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        if (num == 0) return 0;
        int[] cache = new int[10];
        char[] digits = Integer.toString(num).toCharArray();
        for (int i = 0; i < digits.length; i++) cache[digits[i] - '0'] = i;
        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) {
                int index = cache[j];
                if (i < index) {
                    char temp = digits[i];
                    digits[i] = digits[index];
                    digits[index] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
}