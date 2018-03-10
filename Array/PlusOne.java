/**
 * 
 * Date: 03/09/2018
 * Created By: Shuai Liu
 * 
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
*/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int m = digits.lenght - 1;
        while (m >= 0) {
            if (digits[m] < 9) {
                digits[m]++;
                return digits;
            }
            digits[m] = 0;
            m--;
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}