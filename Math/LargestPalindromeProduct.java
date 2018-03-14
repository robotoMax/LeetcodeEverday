/**
 * 
 * Date: 03/13/2018
 * Created By: Shuai Liu
 * 
 * Find the largest palindrome made from the product of two n-digit numbers.
 * Since the result could be very large, you should return the largest palindrome mod 1337.
 * Example:
 * Input: 2
 * Output: 987
 * Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 * Note:
 * The range of n is [1,8].
 */
public class LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int upperBound = (int) Math.pow(10, n) - 1;
        int lowerBound = upperBound / 10 + 1;
        long maxNum = (long) upperBound * (long) upperBound;
        int half = (int) (maxNum / (long) Math.pow(10, n));
        long palindrome = 0;
        boolean found = false;
        while (!found) {
            palindrome = createPalindrome(half);
            for (long i = upperBound; i >= lowerBound; i--) {
                if (i * i < palindrome) break;
                if (palindrome % i == 0) {
                    found = true;
                    break;
                }
            }
            half--;
        }
        return (int) (palindrome % 1337);
    }
    public long createPalindrome(int half) {
        return Long.parseLong(half + new StringBuilder().append(half).reverse().toString());
    }
}