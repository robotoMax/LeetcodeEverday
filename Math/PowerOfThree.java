/**
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 2) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
    // solution for the follow up:
    public boolean isPowerOfThree1(int n) {
        int maxPow = (int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3)));
        return (n > 0 && maxPow % n == 0);
    }
}