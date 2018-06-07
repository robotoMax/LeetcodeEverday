/**
 * Date: 06/04/2018
 * Created By: Shuai Liu
 * 
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 * Example 1:
 * Input: 16
 * Returns: True
 * 
 * Example 2:
 * Input: 14
 * Returns: False
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        int j = num;
        while (i <= j) {
            long mid = i + (j - i) / 2;
            if (mid * mid == num) return true;
            else if (mid * mid < num) i = (int) mid + 1;
            else j = (int) mid - 1;
        }
        return false;
    }
}