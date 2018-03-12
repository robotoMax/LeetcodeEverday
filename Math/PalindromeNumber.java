/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x >= 0) {
            int reverse = 0;
            int copy = x;
            while (copy > 0) {
                reverse = reverse * 10 + copy % 10;
                copy /= 10;
            }
            return reverse == x;
        }
        return false;
    }
}